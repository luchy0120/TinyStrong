package com.goodcompany.token;


import com.goodcompany.OperandStore;
import com.goodcompany.util.ExceptionHolder;
import org.junit.Assert;
import org.junit.Test;

public class PlusTests {

    @Test
    public void testCalculate() {
        Plus plus = new Plus("plus", 13);
        Operand first = new Operand("123");
        Operand second = new Operand("0.50000000000000000000000000000000000001");
        Operand rv = plus.calculate(first, second);
        Assert.assertEquals(rv, new Operand("123.5000000000000000000000000000000"));
        Operand third = new Operand("0.50000000009");
        Operand fourth = new Operand("0.00000000009");
        rv = plus.calculate(third, fourth);
        Assert.assertEquals(rv, new Operand("0.50000000018"));
        Assert.assertNotEquals(rv, new Operand("0.500000000181"));
    }

    @Test
    public void testOperate() {
        Plus plus = new Plus("plus", 14);
        OperandStore store = new OperandStore();
        RollbackManager rm = new RollbackManager();
        ExceptionHolder h = new ExceptionHolder();
        boolean rv = plus.operate(store, rm, h);
        Assert.assertEquals(rv, false);
        Assert.assertEquals(rm.ready(), false);
        Assert.assertEquals(h.getMessage(), "operator plus (position: 14): insufficient parameters");
        store.store(new Operand("4"));
        store.store(new Operand("5"));
        rv = plus.operate(store, rm, h);
        Assert.assertEquals(store.fetch(), new Operand("9.00"));
        store.store(new Operand("9"));
        Assert.assertEquals(rv, true);
        Assert.assertEquals(rm.ready(), true);
        rm.undo(store);
        Assert.assertEquals(store.fetch(), new Operand("5.00"));
        Assert.assertEquals(store.fetch(), new Operand("4.00"));
    }

}
