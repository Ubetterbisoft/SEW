package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class Sub implements Instruction {

    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getOutStack().push(-interpreter.getInStack().pop()+interpreter.getInStack().pop());
    }
}
