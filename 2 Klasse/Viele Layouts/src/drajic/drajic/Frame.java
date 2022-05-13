package drajic.drajic;
import javax.swing.*;
import java.awt.*;
/**
 * Das Frame wird erstellt, BAsisfunktionen und aus sichtbar gesetzt
 * Das Frame() wird in main aufgerufen
 * @author draji
 * @version 2022.05.12
 */
public class Frame extends JFrame {

    public static void main(String[] args){
        new Frame();
    }

    public Frame(){
        super("Viele Layouts");

        this.add(new Panel());


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));


        this.pack();
        this.setVisible(true);
    }

}
