package com.goodcompany.token;

import com.goodcompany.OperandStore;
import org.junit.Assert;
import org.junit.Test;

public class RollbackManagerTests {

    @Test
    public void testUndo() {
        class TestRolllback extends Rollback {
            TestRolllback(Operand[] ops) {
                super(ops);
            }

            @Override
            public void rollback(OperandStore store) {
                store.fetch();
                store.store(rollbacks[0]);
            }
        }

        RollbackManager manager = new RollbackManager();
        manager.record(new TestRolllback(new Operand[]{new Operand("34")}));
        Assert.assertEquals(manager.ready(), true);
        OperandStore store = new OperandStore();
        store.store(new Operand("23232424242"));
        manager.undo(store);
        Assert.assertEquals(store.fetch(), new Operand("34.0"));

    }

}
