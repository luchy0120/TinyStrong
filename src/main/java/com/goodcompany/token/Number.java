package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.util.ExceptionHolder;

public final class Number extends Token {

    private Operand operand;

    public Number(String data, int startPos) {
        super(data, startPos);
        operand = new Operand(data);
    }

    @Override
    public boolean operate(OperandStore store, RollbackManager manager, ExceptionHolder holder) {
        manager.record(new OperandRollback(new Operand[0]));
        store.store(operand);
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Number) {
            return this.operand.equals((((Number) other).operand)) && super.equals(other);
        }
        return false;
    }

    public class OperandRollback extends Rollback {

        public OperandRollback(Operand[] rollbacks) {
            super(rollbacks);
        }

        @Override
        public void rollback(OperandStore store) {
            store.fetch();
        }
    }

}
