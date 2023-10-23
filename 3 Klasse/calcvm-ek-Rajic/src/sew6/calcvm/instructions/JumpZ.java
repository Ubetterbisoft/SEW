package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class JumpZ implements Instruction {
    private int line;

    public JumpZ(int line) {
        if(line < 1)
            throw new IllegalArgumentException("Die Zeile muss positiv sein!");
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    @Override
    public void execute(Interpreter interpreter) {
        int value = interpreter.getInStack().pop();
        if(value == 0)
            interpreter.setCurrentLine(line-1);
        else
            interpreter.getOutStack().push(value);
    }
}
