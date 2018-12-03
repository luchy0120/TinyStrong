package com.goodcompany;

import com.goodcompany.exception.ErrorInputException;
import com.goodcompany.token.Token;
import com.goodcompany.token.Tokenizer;
import com.goodcompany.util.ConsoleUtil;
import java.util.List;

public class Launcher {

    public static void main(String args[]) {
        Evaluator evaluator = new Evaluator();

        for (; ; ) {
            String input = ConsoleUtil.readInput();
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = null;
            try {
                tokens = tokenizer.getTokens();
            } catch (ErrorInputException ex) {
                ConsoleUtil.println(String.format("please check yout input. %s", ex.getMessage()));
                continue;
            }
            evaluator.evaluate(tokens);
        }
    }

}
