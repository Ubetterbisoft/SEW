package drajic;
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(){

        //GridLayout ist das Hauptlayout
        GridLayout grid = new GridLayout(2,3,5,5);
        this.setLayout(grid);

        //Borderlayout
        JPanel border = new JPanel(new BorderLayout(5,10));



        JButton pageStart = new JButton("Page_Start");
        JButton lineStart = new JButton("Line_Start");
        JButton center = new JButton("BorderLayout.Center");
        JButton pageEnd = new JButton("Page-End");
        border.setMaximumSize(new Dimension(getWidth() /3,getHeight() /2));
        //hinzufügen der Komponenten in das border panel
        border.add(pageStart,BorderLayout.PAGE_START);
        border.add(lineStart,BorderLayout.LINE_START);
        border.add(center,BorderLayout.CENTER);
        border.add(pageEnd,BorderLayout.PAGE_END);






        //--------------------------------------------------------------------

        JPanel flow = new JPanel(new FlowLayout());
        JButton test = new JButton("test");
        JButton test1 = new JButton("test1");
        JButton test2 = new JButton("test2");
        JButton test3 = new JButton("test3");
        flow.add(test);
        flow.add(test1);
        flow.add(test2);
        flow.add(test3);

        //Hizufügen der Panels in das Main Grid Layout

        //Es müssen vorers alle Komponenten eingetragen sein damit das richtige Layout dargestellt wird
        this.add(border);
        this.add(flow);
        this.add(test);
        this.add(test1);
        this.add(test2);
        this.add(test3);

        /**
        this.add(test);
        this.add(test1);
        this.add(test2);
        this.add(test3);
        this.add(pageStart);
        this.add(pageEnd);
         */




        /**
         * this.add(Borderlayout)
         * this.add(Flowlayout)
         * this.add(Boxlayout)
         * this.add(Gridlayout)
         * this.add(BoxLayout)
         * this.add(Letzet Button in der Grid Layout zelle)
         */












    }
}
