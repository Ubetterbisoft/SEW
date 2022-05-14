package Schwere_Grafik;



import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    public static void main(String[] args){
        new Frame();
    }

    public Frame(){
        super("Schwerere Grafik");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,300));
        this.add(new Grafik());
        this.setMinimumSize(new Dimension(310,250));
        this.pack();
        this.setVisible(true);

    }
}
