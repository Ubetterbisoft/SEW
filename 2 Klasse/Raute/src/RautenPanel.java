

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RautenPanel extends JPanel {



    private JLabel bre = new JLabel("Breite:");
    private JLabel ho = new JLabel("Höhe:");
    private JButton fuellung;
    private JTextField breite = new JTextField(5);
    private JTextField hoehe = new JTextField(5);
    private RautenGrafik grafik;
    private boolean fuel;

    public RautenPanel() {
        this.setLayout(new BorderLayout());


        grafik = new RautenGrafik(0, 0, false);
        this.add(grafik);
        JPanel unten = new JPanel(new GridLayout(1,3));
        unten.add(bre);
        unten.add(breite);
        unten.add(ho);
        unten.add(hoehe);


        fuellung = new JButton("Gefüllt");
        fuel = false;
        unten.add(fuellung);
        this.add(unten, BorderLayout.PAGE_END);

        ActionHandler ah = new ActionHandler();
        fuellung.addActionListener(ah);
        breite.addActionListener(ah);
        hoehe.addActionListener(ah);


    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fuellung && grafik.fuellung == false) {
                grafik.setFuel(true);
                fuellung.setText("Hohl");

            } else {
                if (e.getSource() == fuellung && grafik.fuellung == true) {
                    grafik.setFuel(false);
                    fuellung.setText("Gefüllt");

                }
            }

            if (e.getSource() == breite) {

                try {
                    grafik.setBreite(Integer.parseInt(breite.getText()));
                } catch (IllegalArgumentException exc) {
                    grafik.setBreite(0);
                }
            }
            if (e.getSource() == hoehe) {

                try {
                    grafik.setHoehe(Integer.parseInt(hoehe.getText()));
                } catch (IllegalArgumentException exc) {
                    grafik.setHoehe(0);
                }
            }
        }
    }
}
