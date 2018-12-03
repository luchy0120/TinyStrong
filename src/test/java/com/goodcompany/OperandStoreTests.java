package com.goodcompany;

import com.goodcompany.token.Operand;
import org.junit.Assert;
import org.junit.Test;

public class OperandStoreTests {

    @Test
    public void testStoreAndFetch() {
        OperandStore store = new OperandStore();
        store.store(new Operand("123"));
        store.store(new Operand("213243413"));
        store.store(new Operand("12546543"));
        store.fetch();
        store.fetch();
        Assert.assertFalse(store.checkTwoOperands());
        Assert.assertEquals(store.fetch(), new Operand("123"));
    }

}
