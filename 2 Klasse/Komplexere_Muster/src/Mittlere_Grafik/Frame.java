package Mittlere_Grafik;

import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
    public static void main(String[] args){
        new Frame();
    }

    public Frame(){
        super("Mittlere Grafik");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,300));
        this.add(new Grafik());
        this.pack();
        this.setVisible(true);
    }
}
