
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RautenGrafik extends JPanel {

    int breite, hoehe;
    boolean fuellung;

    public RautenGrafik(int breite, int hoehe, boolean fuellung){
        this.breite = breite;
        this.hoehe = hoehe;
        this.fuellung = fuellung;
    }

    public void setFuel(boolean fuel){
        this.fuellung = fuel;
        this.repaint();
    }

    public void setBreite(int breite){
        this.breite = breite;
        this.repaint();
    }

    public void setHoehe(int hoehe){
        this.hoehe = hoehe;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int breite = this.getWidth();
        int hoehe = this.getHeight();

        int[] x = {breite/2 - this.breite/2, breite/2, breite/2 + this.breite/2, breite/2};
        int[] y = {hoehe/2, hoehe/2 + this.hoehe/2, hoehe/2, hoehe/2 - this.hoehe/2};

        if (fuellung == true){
            g.setColor(Color.BLUE);
            g.fillPolygon(x,y,4);
        } else {
            g.drawPolygon(x,y,4);
        }
    }
}
