package com.goodcompany.token;

public final class Plus extends BinaryOperator {

    public Plus(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    Operand calculate(Operand first, Operand second) {
        return first.plus(second);
    }
}
