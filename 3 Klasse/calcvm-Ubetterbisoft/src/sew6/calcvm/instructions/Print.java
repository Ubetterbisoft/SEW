package sew6.calcvm.instructions;
import sew6.calcvm.Interpreter;

/**
 * Die Klasse Print bietet die Ausführbare Methode execute welche
 * den letzten Wert vom Stack über den Interpreter mit getStack ausgibt
 * @author Dejan Rajic
 * @version 2023.03.03
 */
public class Print implements Instruction {

    @Override
    public void execute(Interpreter interpreter) {
        System.out.println(interpreter.getStack().pop());
    }
    //Gibt den Art des Befehls für Program.java an
    @Override
    public String toString(){
        return "Print";
    }
}
