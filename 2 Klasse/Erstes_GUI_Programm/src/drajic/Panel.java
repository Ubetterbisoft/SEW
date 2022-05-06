package drajic;

import java.awt.*;
import javax.swing.*;
public class Panel extends JPanel{
    public Panel(){
        JLabel label = new JLabel("Dejan Rajic");
        label.setOpaque(true);
        label.setBackground(new Color(22,158,33));
        this.setBackground(new Color(22,158,33));

        this.add(label);

    }
}
