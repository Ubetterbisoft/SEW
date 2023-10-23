package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class StoreRes implements Instruction {
    private int value;

    public StoreRes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getOutStack().push(value);
    }
}
