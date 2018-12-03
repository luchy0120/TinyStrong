package com.goodcompany.token;

public final class Divide extends BinaryOperator {

    public Divide(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    Operand calculate(Operand first, Operand second) {
        return second.divide(first);
    }
}
