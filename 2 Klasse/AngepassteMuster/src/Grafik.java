import javax.swing.*;
import java.awt.*;
public class Grafik extends JLabel{
    public Grafik(){
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(700,600));
        this.add(label);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int mitteX = super.getWidth()/2;
        int mitteY = super.getHeight()/2;

        //Linker Kreisturm
        g.drawArc(mitteX -150,mitteY -65, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY -55, 40,40,0,360);
        g.drawArc(mitteX -150, mitteY -45, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY-35, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY-25, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY-15, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY-5, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY+5, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY+15, 40,40,0,360);
        g.drawArc(mitteX -150,mitteY+25, 40,40,0,360);

        //Zentrierte Rechtecke
        g.drawRect(mitteX -100,mitteY-65,200,130);
        g.drawRect(mitteX -90,mitteY-55,180,110);
        g.drawRect(mitteX -80,mitteY -45,160,90);
        g.drawRect(mitteX -70,mitteY- 35,140,70);
        g.drawRect(mitteX -60,mitteY -25,120,50);
        g.drawRect(mitteX -50,mitteY- 15,100,30);
        g.drawRect(mitteX -40,mitteY -5,80,10);

        //Rechter Kreisturm
        g.drawArc(mitteX +110,mitteY -65, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY -55, 40,40,0,360);
        g.drawArc(mitteX +110, mitteY -45, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY-35, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY-25, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY-15,40,40,0,360);
        g.drawArc(mitteX +110,mitteY-5, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY+5, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY+15, 40,40,0,360);
        g.drawArc(mitteX +110,mitteY+25, 40,40,0,360);

    }
}
