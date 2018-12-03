package com.goodcompany.token;

public final class Minus extends BinaryOperator {

    public Minus(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    Operand calculate(Operand first, Operand second) {
        return second.minus(first);
    }
}
