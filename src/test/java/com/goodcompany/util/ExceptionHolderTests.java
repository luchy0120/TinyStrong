package com.goodcompany.util;

import org.junit.Assert;
import org.junit.Test;

public final class ExceptionHolderTests {

    @Test
    public void testGetMessage() {
        ExceptionHolder h = new ExceptionHolder();
        Assert.assertEquals("", h.getMessage());
    }

}
