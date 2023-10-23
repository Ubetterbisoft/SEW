package sew6.calcvm;

import sew6.calcvm.instructions.Add;
import sew6.calcvm.instructions.Print;
import sew6.calcvm.instructions.Store;
import sew6.calcvm.instructions.Sub;

/**
 * Instructions werden hinzugefügt und vom interpreter bearbeitet.
 * Ausgabe nach testklassen Schema
 */
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Interpreter interpreter = new Interpreter(program);
        program.addInstruction(new Store(3));
        program.addInstruction(new Store(5));
        program.addInstruction(new Add());
        program.addInstruction(new Print());
        program.addInstruction(new Store(10));

        program.addInstruction(new Add());
        program.addInstruction(new Print());
        program.size();



        interpreter.run();
        System.out.println("Test der to-String Methode:");
        System.out.println(program.toString());

        System.out.println(("Test des Delete Instruction:"));
        program.deleteInstruction(2);
        System.out.println(program.toString());

        System.out.println("Test der size():\n"+program.size());

    }
}
