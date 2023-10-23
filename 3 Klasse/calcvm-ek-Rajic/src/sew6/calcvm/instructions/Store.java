package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class Store implements Instruction {
    private int value;

    public Store(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getInStack().push(value);
    }
}
