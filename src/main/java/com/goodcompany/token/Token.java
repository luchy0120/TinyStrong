package com.goodcompany.token;

public abstract class Token implements Operate {

    protected final String data;

    protected final int startPos;

    public Token(String data, int startPos) {
        this.startPos = startPos;
        this.data = data;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Token) {
            return this.data.equals(((Token) other).data) && this.startPos == ((Token) other).startPos;
        }
        return false;
    }

}

