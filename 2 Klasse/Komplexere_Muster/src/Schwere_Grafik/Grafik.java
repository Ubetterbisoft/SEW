package Schwere_Grafik;

import java.awt.*;
import javax.swing.*;

/**
 * es wird mit for die aktuelle positionierung der rechtecke berechnet
 * @author draji
 * @version 2022.05.13
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

        //count ist der Zähler um später zu Multiplizieren um den spaltenabstand zu erreichen
        int count = 0;

        //es werden 10 zeile erstellt, i wird pro durchgang kleiner um es mit dem zweiten for zu vergleichen
        for(int i = 10;  i >0; i--){
            count++;
            //solange die anzahl der Rechtecke kleiner ist als die anzahl der Zeilen (erstellt dsa gleichseitige dreieck)
            for(int j = 0;j < i;j++){
                g.drawRect(mx-150,my-100,30,20);
                mx = mx +30;
            }
            //Pro neue zeile wird der y wert dazu genommen
            my = my +20;
            // wird wieder auf 0 gesetzt
            mx = getWidth()/2;
            //abstand wird berechnet
            mx = mx + count* 15;





        }
    }

}
