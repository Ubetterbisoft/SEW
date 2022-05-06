import javax.swing.*;
import java.awt.*;

/**
 * Die Frame Klasse in der das Frame mit dem Label aufgerufen wird
 */
public class Frame extends JFrame{
    public Frame(){
        super("Dejan`s erste Java-Zeichnung");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400,400));
        this.add(new Grafik());
        this.pack();
        this.setVisible(true);


    }
    public static void main(String[]args){
        new Frame();
    }
}
