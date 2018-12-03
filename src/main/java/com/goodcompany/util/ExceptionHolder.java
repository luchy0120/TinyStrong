package com.goodcompany.util;

import com.goodcompany.exception.OperateException;

public final class ExceptionHolder {

    private OperateException hold;

    public ExceptionHolder() {

    }

    public void reportException(OperateException exception) {
        hold = exception;
    }

    public String getMessage() {
        if (hold != null) {
            return hold.getMessage();
        }
        return "";
    }

    public void release() {
        hold = null;
    }
}
