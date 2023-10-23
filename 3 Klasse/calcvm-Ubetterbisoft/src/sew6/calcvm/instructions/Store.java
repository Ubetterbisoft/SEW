package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;
/**
 * Die Klasse Store bietet die Ausführbare Methode execute welche
 * die einen Wert mithilfe des Interpreter am Stack speichert
 * @author Dejan Rajic
 * @version 2023.03.03
 */
public class Store implements Instruction {
    private int value;
    public Store(int value) {
        this.value = value;
    }

    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getStack().push(value);
    }
    //Gibt den Art des Befehls für Program.java an
    @Override
    public String toString() {
        return "Store " + value;
    }
}