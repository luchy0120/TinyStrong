package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.util.ExceptionHolder;

public interface Operate {

    public boolean operate(OperandStore store, RollbackManager manager, ExceptionHolder holder);

}

