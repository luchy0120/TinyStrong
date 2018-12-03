package com.goodcompany.token;

import com.goodcompany.OperandStore;

import java.util.Stack;

public class RollbackManager {

    private final Stack<Rollback> memo = new Stack<>();

    public void record(Rollback rb) {
        memo.push(rb);
    }

    public void undo(OperandStore store) {
        memo.pop().rollback(store);
    }

    public boolean ready() {
        return !memo.empty();
    }

}
