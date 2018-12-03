package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.exception.OperateException;
import com.goodcompany.util.ExceptionHolder;

public abstract class UnaryOperator extends Token {

    public UnaryOperator(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    public boolean operate(OperandStore store, RollbackManager manager, ExceptionHolder holder) {
        if (store.empty()) {
            holder.reportException(new OperateException(String.format("operator %s (position: %d): insufficient parameters", data, startPos)));
            return false;
        }
        Operand operand = store.fetch();
        try {
            store.store(calculate(operand));
        } catch (ArithmeticException ex) {
            store.store(operand);
            holder.reportException(new OperateException(String.format("operator %s (position: %d): %s", data, startPos, ex.getMessage())));
            return false;
        }
        manager.record(new UnaryRollback(new Operand[]{operand}));
        return true;
    }

    abstract Operand calculate(Operand operand);

    private class UnaryRollback extends Rollback {

        public UnaryRollback(Operand[] rollbacks) {
            super(rollbacks);
        }

        @Override
        public void rollback(OperandStore store) {
            store.fetch();
            for (Operand op : rollbacks) {
                store.store(op);
            }
        }
    }

}
