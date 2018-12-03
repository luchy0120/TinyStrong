package com.goodcompany.token;

import com.goodcompany.exception.ErrorInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {

    private String input = "";

    private int pos = 0;

    private int length;

    public Tokenizer(String inputData) {
        this.input = inputData;
        this.length = input.length();
    }

    private static boolean isDecimal(String number) {
        return number.matches("[-+]?\\d+\\.\\d+");
    }

    private static boolean isInteger(String number) {
        return number.matches("[-+]?\\d+");
    }

    void jumpWhiteSpace() {
        while (pos < length && input.charAt(pos) == ' ') {
            pos++;
        }
    }

    public List<Token> getTokens() throws ErrorInputException {
        List<Token> tokens = new ArrayList<>();
        jumpWhiteSpace();

        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int reportPos = pos + 1;
            switch (token) {
                case "+":
                    tokens.add(new Plus(token, reportPos));
                    break;
                case "-":
                    tokens.add(new Minus(token, reportPos));
                    break;
                case "*":
                    tokens.add(new Multiply(token, reportPos));
                    break;
                case "/":
                    tokens.add(new Divide(token, reportPos));
                    break;
                case "undo":
                    tokens.add(new Undo(token, reportPos));
                    break;
                case "clear":
                    tokens.add(new Clear(token, reportPos));
                    break;
                case "sqrt":
                    tokens.add(new Sqrt(token, reportPos));
                    break;
                default:
                    if (isDecimal(token) || isInteger(token)) {
                        tokens.add(new Number(token, reportPos));
                    } else {
                        throw new ErrorInputException("Error input, some token is not recognized.");
                    }
            }
            pos += token.length();
            jumpWhiteSpace();
        }

        return tokens;
    }

}

