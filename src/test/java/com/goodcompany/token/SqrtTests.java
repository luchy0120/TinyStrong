package com.goodcompany.token;

import com.goodcompany.OperandStore;
import com.goodcompany.util.ExceptionHolder;
import org.junit.Assert;
import org.junit.Test;

public class SqrtTests {

    @Test
    public void testCalculate() {
        Sqrt sqrt = new Sqrt("sqrt", 13);
        Operand op = new Operand("123455677");
        Operand rv = sqrt.calculate(op);
        Assert.assertEquals(rv, new Operand("11111.06102044264717753318861155088"));
        Assert.assertEquals(rv.toString(), "11111.0610204426");
        Assert.assertEquals(rv, new Operand("11111.061020442647177533188611550"));
        Assert.assertNotEquals(rv, new Operand("11111.0610204426471775331"));
    }

    @Test
    public void testOperate() {
        Sqrt sqrt = new Sqrt("sqrt", 14);
        OperandStore store = new OperandStore();
        RollbackManager rm = new RollbackManager();
        ExceptionHolder h = new ExceptionHolder();
        boolean rv = sqrt.operate(store, rm, h);
        Assert.assertEquals(rv, false);
        Assert.assertEquals(rm.ready(), false);
        Assert.assertEquals(h.getMessage(), "operator sqrt (position: 14): insufficient parameters");
        store.store(new Operand("4"));
        rv = sqrt.operate(store, rm, h);
        Assert.assertEquals(store.fetch(), new Operand("2.00"));
        store.store(new Operand("2"));
        Assert.assertEquals(rv, true);
        Assert.assertEquals(rm.ready(), true);
        rm.undo(store);
        Assert.assertEquals(store.fetch(), new Operand("4.00"));
    }

}
