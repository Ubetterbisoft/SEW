package sew6.calcvm;

import sew6.calcvm.instructions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Program program1 = new Program();
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie den ersten Multiplikator ein:");
        int a = sc.nextInt();
        System.out.println("Geben Sie den zweiten Multiplikator ein:");
        int b = sc.nextInt();
        System.out.println("Ergebnis:");
        program1.addInstruction(new Store(a));
        program1.addInstruction(new StoreRes(b));
        program1.addInstruction(new Store(1));
        program1.addInstruction(new Sub());
        program1.addInstruction(new ShiftRes());
        program1.addInstruction(new JumpZ(12));
        program1.addInstruction(new ShiftRes());
        program1.addInstruction(new ShiftRes());
        program1.addInstruction(new Store(b));
        program1.addInstruction(new Add());
        program1.addInstruction(new Jump(3));
        program1.addInstruction(new Print());

        Interpreter interpreter = new Interpreter(program1);
        interpreter.run();
    }
}
