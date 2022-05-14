package Mittlere_Grafik;

import javax.swing.*;
import java.awt.*;

public class Grafik extends JPanel {
    public Grafik(){
        this.setOpaque(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int mx = getWidth() /2;
        int my = getHeight() /2;

        g.drawRoundRect(mx -150,my -70,300,150,90,90);
        g.drawRoundRect(mx-130,my-55,260,120,90,90);
        g.drawArc(mx-110,my-35,80,80,90,180);
        g.drawArc(mx-90,my-35,80,80,90,180);
        g.drawArc(mx-70,my-35,80,80,90,180);

        g.drawArc(mx-40,my-35,80,80,0,360);


       g.drawArc(mx-10,my-35,80,80,90,-180);
       g.drawArc(mx+10,my-35,80,80,90,-180);

        g.drawArc(mx+30,my-35,80,80,90,-180);
        g.drawLine(mx -70,my -35,mx+70,my-35);
        g.drawLine(mx -70,my +45,mx+70,my+45);

    }
}
