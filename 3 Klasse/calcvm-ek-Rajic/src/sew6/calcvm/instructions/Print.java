package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class Print implements Instruction {

    @Override
    public void execute(Interpreter interpreter) {
        System.out.println(interpreter.getOutStack().pop());
    }
}
