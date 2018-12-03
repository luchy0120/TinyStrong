package com.goodcompany;

import com.goodcompany.token.Operand;
import java.util.Iterator;
import java.util.Stack;

public class OperandStore {

    private final Stack<Operand> store;

    private int size;

    public OperandStore() {
        store = new Stack<Operand>();
        size = 0;
    }

    public void store(Operand operand) {
        store.push(operand);
        ++size;
    }

    public Operand fetch() {
        --size;
        return store.pop();
    }

    public void clear() {
        store.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean checkTwoOperands() {
        return size >= 2;
    }

    public Operand[] toArray() {
        return store.toArray(new Operand[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("stack: ");
        Iterator<Operand> iterator = store.iterator();
        if (!iterator.hasNext()) {
            return sb.toString();
        }

        for (; ; ) {
            Operand op = iterator.next();
            sb.append(op);
            if (iterator.hasNext()) {
                sb.append(" ");
            } else {
                return sb.toString();
            }
        }
    }

}
