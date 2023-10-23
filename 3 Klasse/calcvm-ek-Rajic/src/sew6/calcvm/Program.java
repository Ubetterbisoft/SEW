package sew6.calcvm;

import sew6.calcvm.instructions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Programm bestehend aus Instructions für mathematische Berechnungen
 */
public class Program {
    private List<Instruction> instructions = new ArrayList<>();

    /**
     * Liefert die Instruction an der übergebenen Zeile
     * @param line Zeile
     * @return Instruction an der übergebenen Zeile
     */
    public Instruction getInstruction(int line) {
        if(line < 1 || line > size())
            throw new IllegalArgumentException("Die Zeile muss positiv sein und darf maximal die Größe des Programms sein!");
        return instructions.get(line-1);
    }

    /**
     * Löscht die Instruction an der übergebenen Zeile und liefert die gelöschte Instruction
     * @param line Zeile
     * @return die gelöschte Instruction
     */
    public Instruction deleteInstruction(int line) {
        if(line < 1 || line > size())
            throw new IllegalArgumentException("Die Zeile muss positiv sein und darf maximal die Größe des Programms sein!");
        return instructions.remove(line);
    }

    /**
     * Fügt eine Instruction am Ende des Programms hinzu
     * @param instruction Instrcution, die hinzugefügt wird
     */
    public void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    /**
     * Liefert die aktuelle Größe des Programms
     * @return aktuelle Größe des Programms
     */
    public int size() {
        return instructions.size();
    }

    /**
     * Liefert das Programm als String in der gegebenen Notation
     * @return das Programm als String
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for(Instruction instruction: instructions) {
            if(instruction instanceof Add)
                text.append("Add\n");
            else if(instruction instanceof Sub)
                text.append("Sub\n");
            else if(instruction instanceof Print)
                text.append("Print\n");
            else
                text.append("Store " + ((Store)instruction).getValue() + "\n");
        }
        return text.toString();
    }
}
