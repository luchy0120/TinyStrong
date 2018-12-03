package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.exception.OperateException;
import com.goodcompany.util.ExceptionHolder;

public abstract class BinaryOperator extends Token {

    public BinaryOperator(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    public boolean operate(OperandStore store, RollbackManager manager, ExceptionHolder holder) {
        if (!store.checkTwoOperands()) {
            holder.reportException(new OperateException(String.format("operator %s (position: %d): insufficient parameters", data, startPos)));
            return false;
        }
        Operand first = store.fetch();
        Operand second = store.fetch();
        try {
            store.store(calculate(first, second));
        } catch (ArithmeticException ex) {
            store.store(second);
            store.store(first);
            holder.reportException(new OperateException(String.format("operator %s (position: %d): %s", data, startPos, ex.getMessage())));
            return false;
        }
        manager.record(new BinaryRollback(new Operand[]{second, first}));
        return true;
    }

    abstract Operand calculate(Operand first, Operand second);

    private class BinaryRollback extends Rollback {

        public BinaryRollback(Operand[] rollbacks) {
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
