package sew6.calcvm;

import java.util.LinkedList;

/**
 * Ein Stapel, in dem Zahlenwerte gespeichert werden können
 */
public class Stack {
    private LinkedList<Integer> elements = new LinkedList<>();

    /**
     * Fügt ein neues Element zum Stack hinzu
     * @param element Element, das hinzugefügt wird
     */
    public void push(int element) {
        elements.push(element);
    }

    /**
     * Entfernt das oberste Element im Stack und liefert es zurück
     * @return das oberste Element im Stack, das gelöscht wurde
     */
    public int pop() {
        return elements.pop();
    }
}
