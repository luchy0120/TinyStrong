package com.goodcompany.token;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TokenizerTests {

    @Test
    public void testGetTokens() {
        Tokenizer tokenizer = new Tokenizer("3.5 + undo  ");
        List<Token> tokens = new ArrayList<>();

        tokens.add(new Number("3.5", 1));
        tokens.add(new Plus("+", 5));
        tokens.add(new Undo("undo", 7));
        List<Token> rv = null;
        try {
            rv = tokenizer.getTokens();
        } catch (Exception ex) {

        }
        Assert.assertEquals(tokens, rv);

    }

}

