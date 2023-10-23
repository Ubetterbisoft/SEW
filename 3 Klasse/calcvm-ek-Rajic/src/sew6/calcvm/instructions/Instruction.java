package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public interface Instruction {
    void execute(Interpreter interpreter);
}
