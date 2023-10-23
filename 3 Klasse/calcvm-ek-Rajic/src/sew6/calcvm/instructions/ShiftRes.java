package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class ShiftRes implements Instruction {
    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getInStack().push(interpreter.getOutStack().pop());
    }
}
