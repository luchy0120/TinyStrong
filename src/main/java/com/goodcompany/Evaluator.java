package com.goodcompany;

import com.goodcompany.token.RollbackManager;
import com.goodcompany.token.Token;
import com.goodcompany.util.ConsoleUtil;
import com.goodcompany.util.ExceptionHolder;
import java.util.List;

public class Evaluator {

    private final OperandStore store = new OperandStore();

    private final RollbackManager memo = new RollbackManager();

    public void evaluate(List<Token> tokens) {
        for (Token token : tokens) {
            ExceptionHolder holder = new ExceptionHolder();
            if (!token.operate(store, memo, holder)) {
                ConsoleUtil.println(holder.getMessage());
                holder.release();
                ConsoleUtil.println(store);
                return;
            }
        }
        ConsoleUtil.println(store);
    }

}

