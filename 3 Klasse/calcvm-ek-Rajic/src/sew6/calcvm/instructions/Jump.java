package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;

public class Jump implements Instruction {
    private int line;

    public Jump(int line) {
        if(line < 1)
            throw new IllegalArgumentException("Die Zeile muss positiv sein!");
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    @Override
    public void execute(Interpreter interpreter) {
        interpreter.setCurrentLine(line-1);
    }
}
