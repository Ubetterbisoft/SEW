package drajic;
import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {

    public static void main(String[] args){
        new Frame();
    }

    public Frame(){
        super("Viele Layouts");

        this.add(new Panel());


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,500));


        this.pack();
        this.setVisible(true);
    }

}
