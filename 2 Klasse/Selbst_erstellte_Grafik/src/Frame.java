import javax.swing.*;
import java.awt.*;

/**
 * Die klasse erstellte das Frame und führt es aus
 * @author draji
 * @version 2022.05.07
 */
public class Frame extends JFrame {

    public Frame(){
        super("Dejan's erste eigene Java Zeichnung");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,700));
        this.add(new Grafik());
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[]args){
        new Frame();
    }

}
