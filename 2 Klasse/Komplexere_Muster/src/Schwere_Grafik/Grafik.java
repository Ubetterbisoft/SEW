package Schwere_Grafik;

import java.awt.*;
import javax.swing.*;

/**
 * es wird mit for die aktuelle positionierung der rechtecke berechnet
 */
public class Grafik extends JPanel {
    public Grafik(){
        this.setOpaque(true);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int mx = getWidth() /2;
        int my = getHeight() /2;

        int xVar = 0;
        int yVar = 0;

        int count = 0;

        for(int i = 10;  i >0; i--){
            count++;
            for(int j = 0;j < i;j++){
                g.drawRect(mx-150,my-100,30,20);
                mx = mx +30;
            }
            my = my +20;
            mx = getWidth()/2;
            mx = mx + count* 15;





        }
    }

}
