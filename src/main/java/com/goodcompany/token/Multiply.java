package com.goodcompany.token;

public final class Multiply extends BinaryOperator {

    public Multiply(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    Operand calculate(Operand first, Operand second) {
        return first.multiply(second);
    }
}
