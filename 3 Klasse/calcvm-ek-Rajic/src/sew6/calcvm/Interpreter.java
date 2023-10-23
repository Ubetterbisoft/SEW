package sew6.calcvm;

public class Interpreter {
    private Stack inStack = new Stack();
    private Stack outStack = new Stack();
    private Program program;
    private int currentLine;

    public Interpreter(Program program) {
        this.program = program;
    }

    /**
     * This method implements the actual interpreter.
     * Iterate over all instructions of the program and execute them, the end of the program is reached
     * when all instructions have been executed.
     */
    public void run() {
        for(currentLine = 1; currentLine <= program.size(); currentLine++) {
            program.getInstruction(currentLine).execute(this);
        }
    }
    public Stack getInStack() {
        return inStack;
    }
    public Stack getOutStack() {
        return outStack;
    }
    public void setCurrentLine(int line) {
        if(line < 1 || line > program.size())
            throw new IllegalArgumentException("Die Zeile muss positiv sein und darf maximal die Größe des Programms sein!");
        this.currentLine = line;
    }
}
