package com.goodcompany.token;


import com.goodcompany.OperandStore;
import com.goodcompany.util.ExceptionHolder;
import org.junit.Assert;
import org.junit.Test;

public class ClearTests {

    @Test
    public void testOperate() {
        Clear sqrt = new Clear("clear", 14);
        OperandStore store = new OperandStore();
        RollbackManager rm = new RollbackManager();
        ExceptionHolder h = new ExceptionHolder();
        boolean rv = sqrt.operate(store, rm, h);
        Assert.assertEquals(rv, true);
        Assert.assertEquals(h.getMessage(), "");
        store.store(new Operand("4"));
        rv = sqrt.operate(store, rm, h);
        Assert.assertTrue(store.empty());
        Assert.assertTrue(rv);
    }

}