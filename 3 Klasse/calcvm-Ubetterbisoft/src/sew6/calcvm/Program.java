package sew6.calcvm;

import sew6.calcvm.instructions.Instruction;

import java.util.*;

/**
 * Fügt neue Instructions hinzu und speichert diese für weiterverarbeitung
 */
public class Program {
    private List<Instruction> list;

    public Program(){
        list = new ArrayList<>();
    }

    public Instruction getInstruction(int line){
        return list.get(line);
    }

    public Instruction deleteInstruction(int line){
        Instruction instruction = list.get(line);
        list.remove(line);
        return instruction;
    }

    public List<Instruction> getList() {
        return list;
    }

    public void addInstruction(Instruction instruction){
        list.add(instruction);

    }

    public int size(){
        return list.size();
    }
    @Override
    public String toString(){
        String ausgabe = "";
        for(Instruction instruction: list){
           ausgabe += (instruction + "\n");
        }
        return ausgabe;
    }


}
