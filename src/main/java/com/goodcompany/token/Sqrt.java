package com.goodcompany.token;

public final class Sqrt extends UnaryOperator {

    public Sqrt(String data, int startPos) {
        super(data, startPos);
    }

    @Override
    Operand calculate(Operand operand) {
        return operand.sqrt();
    }

}
