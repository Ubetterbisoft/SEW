package drajic;
import java.awt.*;
import javax.swing.*;
public class Gui extends JFrame {
    //Das frame wird aufgerufen
    public static void main(String[] args){
        new Gui();
    }
    //Der Gui Konstruktor setz das Frame und das Panel zusammen.
    public Gui(){
        super("Dejan Rajic 2cHIT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setBackground(new Color(22,158,33));
        this.add(new Panel());
        this.pack();
        this.setVisible(true);
    }
}
