
import javax.swing.*;

public class RautenFrame extends JFrame {
    public RautenFrame() {
        super("Eine Raute Dejan Rajic");
        RautenPanel mp = new RautenPanel();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 200, 700, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RautenFrame();
    }
}
