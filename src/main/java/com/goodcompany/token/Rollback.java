package com.goodcompany.token;

import com.goodcompany.OperandStore;

public abstract class Rollback {

    protected final Operand[] rollbacks;

    public Rollback(Operand[] rollbacks) {
        this.rollbacks = rollbacks;
    }

    public abstract void rollback(OperandStore store);

}
