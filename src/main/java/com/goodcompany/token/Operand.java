package com.goodcompany.token;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Operand {

    private final BigDecimal val;

    public Operand(String value) {
        this(normalize(new BigDecimal(value)));
    }

    private Operand(BigDecimal value) {
        val = value;
    }

    private static BigDecimal normalize(BigDecimal value) {
        return value.setScale(20, RoundingMode.DOWN).stripTrailingZeros();
    }

    public Operand plus(Operand other) {
        return new Operand(normalize(val.add(other.val)));
    }

    public Operand minus(Operand other) {
        return new Operand(normalize(val.subtract(other.val)));
    }

    public Operand multiply(Operand other) {
        return new Operand(normalize(val.multiply(other.val)));
    }

    public Operand divide(Operand other) {
        return new Operand(normalize(val.divide(other.val, MathContext.DECIMAL128)));
    }

    public Operand sqrt() {
        return new Operand(normalize(val.sqrt(MathContext.DECIMAL128)));
    }

    @Override
    public String toString() {
        return val.setScale(10, RoundingMode.DOWN).stripTrailingZeros().toPlainString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Operand) {
            return val.equals(((Operand) other).val);
        } else {
            return false;
        }
    }

}
