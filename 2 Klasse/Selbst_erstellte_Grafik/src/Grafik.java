import javax.swing.*;
import java.awt.*;

/**
 * Die klasse stellt den Hintergrund ein und Zeichnet einen Leuchtturm mit dynamischen Licht
 * @author draji
 * @version 2022.05.07
 */
public class Grafik extends JLabel{

    public Grafik(){
        JLabel panel = new JLabel();
        this.setOpaque(true);
        Color c = new Color(80, 200, 120);
        this.setBackground(Color.BLUE);
        this.add(panel);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int mitteX = super.getWidth() /2;
        int mittey = super.getHeight() /2;


        //LeuchtturmFarben
        g.setColor(Color.WHITE);
        g.fillRect(mitteX -50,mittey-75,125,40);
        g.setColor(Color.RED);
        g.fillRect(mitteX -50,mittey-35,125,40);
        g.setColor(Color.WHITE);
        g.fillRect(mitteX -50,mittey +5,125,40);
        g.setColor(Color.RED);
        g.fillRect(mitteX -50,mittey+45,125,40);
        g.setColor(Color.WHITE);
        g.fillRect(mitteX -50,mittey+85,125,40);
        g.setColor(Color.RED);
        g.fillRect(mitteX -50,mittey+125,125,40);
        g.setColor(Color.WHITE);
        g.fillRect(mitteX -50,mittey+165,125,40);
        g.setColor(Color.RED);
        g.fillRect(mitteX -50,mittey+205,125,40);
        g.setColor(Color.WHITE);
        g.fillRect(mitteX -50,mittey+245,125,40);

        //Tür
        Color c = new Color(139,69,19);
        g.setColor(c);
        g.fillOval(mitteX +1,mittey +260,20,40);



        //Leutchturm Kopf

        //Schwarzes Outline
        int[] xKoordinate = {mitteX-50,mitteX+75,mitteX +95,mitteX + 95,mitteX+ 75,mitteX- 50,mitteX-70,mitteX-70}; //,350,300,200,150};
        int[] yKoordinate = {mittey-75,mittey-75,mittey-100,mittey -130,mittey-150,mittey-150,mittey-130,mittey-100};//,250,150,150,250};
        g.setColor(Color.BLACK);
        g.fillPolygon(xKoordinate,yKoordinate, 8);

        //Glasfenster
        Color c2 = new Color(32, 178, 170);
        g.setColor(c2);
        g.fillRoundRect(mitteX-50,mittey-130,125,35,20,20);

        //Licht
        g.setColor(Color.YELLOW);
        g.fillArc(mitteX +1,mittey-120,20,20,0,360);

        //Lichtstrahlen
        int[] x = {mitteX +10,0,mitteX-400};
        int[] y = {mittey-110, getHeight(),mittey +300};
        g.fillPolygon(x,y,3);

        //Grauer Boden
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,mittey+285,getWidth(),getHeight());


        //Wolke
        g.setColor(Color.white);
        g.fillArc(mitteX-300,mittey-300,60,50,0,360);
        g.fillArc(mitteX-260,mittey-310,60,50,0,360);
        g.fillArc(mitteX-220,mittey-300,60,50,0,360);
        g.fillArc(mitteX-180,mittey-280,60,50,0,360);
        g.fillArc(mitteX-280,mittey-270,120,50,0,360);
        g.fillArc(mitteX-300,mittey-270,60,50,0,360);
        g.fillArc(mitteX-260,mittey-260,60,50,0,360);
        g.fillArc(mitteX-220,mittey-260,60,50,0,360);
    }
}
