package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.util.ExceptionHolder;

public final class Clear extends Token {

    public Clear(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    public boolean operate(OperandStore store, RollbackManager manager, ExceptionHolder holder) {
        manager.record(new ClearRollback(store.toArray()));
        store.clear();
        return true;
    }

    private class ClearRollback extends Rollback {

        public ClearRollback(Operand[] rollbacks) {
            super(rollbacks);
        }

        @Override
        public void rollback(OperandStore store) {
            store.clear();
            for (Operand op : rollbacks) {
                store.store(op);
            }
        }
    }


}