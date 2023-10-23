package sew6.calcvm;

import sew6.calcvm.instructions.Instruction;

/**
 * Verbindet Programm mit Stack und startet die Ausführung der Befehle
 */
public class Interpreter {
    private Stack stack = new Stack();
    private Program program;

    public Interpreter(Program program) {
        this.program = program;
    }

    /**
     * This method implements the actual interpreter.
     * Iterate over all instructions of the program and execute them, the end of the program is reached
     * when all instructions have been executed.
     */
    public void run() {
        for(Instruction instruction: program.getList()){
            instruction.execute(this);
        }
    }
    public Stack getStack() {
        return stack;
    }
}
