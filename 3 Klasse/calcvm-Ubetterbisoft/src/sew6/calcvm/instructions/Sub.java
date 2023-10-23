package sew6.calcvm.instructions;
import sew6.calcvm.Interpreter;
/**
 * Analog zur Methode Add nur Subtrahiert
 * @author draji
 * @version 2023.03.03
 */
public class Sub implements Instruction {
    // TODO: implement execute method
    private Interpreter interpreter;
    @Override
    public void execute(Interpreter interpreter){
        int a = interpreter.getStack().pop();
        int b = interpreter.getStack().pop();
        interpreter.getStack().push(b-a);
    }
    //Gibt den Art des Befehls für Program.java an
    @Override
    public String toString() {
        return "Sub";
    }
}
