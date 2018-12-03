package com.goodcompany.token;

import org.junit.Assert;
import org.junit.Test;

public class OperandTests {

    @Test
    public void testPlus() {
        Operand first = new Operand("12.3435354545454");
        Operand second = new Operand("342343.5435454354546565645534");
        Operand rv = first.plus(second);
        Assert.assertEquals(rv, new Operand("342355.88708089000005656455"));
        Assert.assertNotEquals(rv, new Operand("342355.887080890000056564"));
        Assert.assertEquals(rv.toString(), "342355.88708089");
    }

    @Test
    public void testMinus() {
        Operand first = new Operand("0.43278932489");
        Operand second = new Operand("-423984875489");
        Operand rv = first.minus(second);
        Assert.assertEquals(rv, new Operand("423984875489.43278932489000000000"));
        Assert.assertNotEquals(rv, new Operand("423984875489.4327893248"));
        Assert.assertEquals(rv.toString(), "423984875489.4327893248");
    }

    @Test
    public void testMultiply() {
        Operand first = new Operand("-5498725973842073");
        Operand second = new Operand("-958948434735897438574");
        Operand rv = first.multiply(second);
        Assert.assertEquals(rv, new Operand("5272994665657479226234387246294323902"));
        Assert.assertNotEquals(rv, new Operand("5272994665657479226234387246294323902.1"));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide() {
        Operand first = new Operand("1.43748");
        Operand second = new Operand("43284793285748534723847");
        Operand rv = first.divide(second);
        Assert.assertEquals(rv, new Operand("0.0000000"));
        first = new Operand("123");
        second = new Operand("654");
        rv = first.divide(second);
        Assert.assertEquals(rv, new Operand("0.18807339449541284403"));
        first = new Operand("32453.238947");
        second = new Operand("0");
        rv = first.divide(second);

    }

    @Test(expected = ArithmeticException.class)
    public void testSqrt() {
        Operand first = new Operand("2");
        Operand rv = first.sqrt();
        Assert.assertEquals(rv, new Operand("1.4142135623730950488"));
        Assert.assertNotEquals(rv, new Operand("1.41421356237309"));
        Operand second = new Operand("-5498725973842073");
        rv = second.sqrt();
    }

}
