package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.exception.OperateException;
import com.goodcompany.util.ExceptionHolder;

public class Undo extends Token {

    public Undo(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    public boolean operate(OperandStore store, RollbackManager manager, ExceptionHolder holder) {
        if (!manager.ready()) {
            holder.reportException(new OperateException(String.format("operator %s (position: %d): insufficient parameters", data, startPos)));
            return false;
        }
        manager.undo(store);
        return true;
    }

}
