package sew6.calcvm.instructions;
import sew6.calcvm.Interpreter;

/**
 * Die Klasse Add bietet die Ausführbare Methode execute welche
 * die Werte vom Stack über den Interpreter mit getStack addiert
 * @author Dejan Rajic
 * @version 2023.03.03
 */
public class Add implements Instruction {
    // TODO: implement execute method
    private Interpreter interpreter;
    @Override
    public void execute(Interpreter interpreter){
        int a = interpreter.getStack().pop();
        int b = interpreter.getStack().pop();
        interpreter.getStack().push(a+b);
    }
    //gibt den art des Befehls für die Ausgabe in Program.java zurück
    @Override
    public String toString() {
        return "Add";
    }
}
