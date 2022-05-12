package drajic;
import javax.swing.*;
import java.awt.*;

/**
 * IN einem Gridlayout werden weitere Layouts verschachtelt, in diesen werden dann Buttons gezeichnet
 * @author draji
 * @version 2022.05.12
 */

public class Panel extends JPanel {

    public Panel(){

        //GridLayout ist das Hauptlayout
        GridLayout grid = new GridLayout(2,3,5,5);
        this.setLayout(grid);

        /**
         * Borderlayout
         */

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


        /**
         * Flowlayout mit rechtsbündigen buttons
         */

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        flow.setBackground(Color.LIGHT_GRAY);
        JButton das = new JButton("Das");
        JButton ist = new JButton("ist");
        JButton ein = new JButton("ein");
        JButton rechtsBuendig = new JButton("rechtsbündiges");
        JButton flowLayout = new JButton("FlowLayout");
        flow.add(das);
        flow.add(ist);
        flow.add(ein);
        flow.add(rechtsBuendig);
        flow.add(flowLayout);

        /**
         * BoxLayout
         */
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box,BoxLayout.LINE_AXIS));

        JButton box1 = new JButton("Ein");
        box1.setAlignmentX(Component.LEFT_ALIGNMENT);


        JButton box2 = new JButton("horizontales");
        box2.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        JButton box3 = new JButton("BoxLayout");
        box3.setAlignmentX(Component.RIGHT_ALIGNMENT);


        box.add(box1);
        //für die kleinen abstände
        box.add(Box.createRigidArea(new Dimension(10,0)));

        box.add(box2);
        box.add(Box.createRigidArea(new Dimension(10,0)));

        box.add(box3);

        /**
         * Nummern (Gridlayout)
         */
        JPanel numbers = new JPanel(new GridLayout(4,3,3,5));
        numbers.setBackground(Color.LIGHT_GRAY);
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton ten = new JButton("10");
        JButton eleven = new JButton("11");
        JButton twelve = new JButton("12");

        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(seven);
        numbers.add(eight);
        numbers.add(nine);
        numbers.add(ten);
        numbers.add(eleven);
        numbers.add(twelve);

        /**
         * Boxlayout in einem Flowlayout
         */
        JPanel flow2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel boxFlow = new JPanel();

        boxFlow.setLayout(new BoxLayout(boxFlow, BoxLayout.PAGE_AXIS));
        boxFlow.setBackground(Color.LIGHT_GRAY);
        JButton btn1 = new JButton("Ein");
        btn1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton btn2 = new JButton("BoxLayout");
        btn2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton btn3 = new JButton("innerhalb");
        btn3.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton btn4 = new JButton("eines");
        btn4.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton btn5 = new JButton("FlowLayouts");
        btn5.setAlignmentX(Component.LEFT_ALIGNMENT);

        boxFlow.add(btn1);
        boxFlow.add(Box.createRigidArea(new Dimension(0,10)));
        boxFlow.add(btn2);
        boxFlow.add(Box.createRigidArea(new Dimension(0,10)));
        boxFlow.add(btn3);
        boxFlow.add(Box.createRigidArea(new Dimension(0,10)));
        boxFlow.add(btn4);
        boxFlow.add(Box.createRigidArea(new Dimension(0,10)));
        boxFlow.add(btn5);


        flow2.add(boxFlow);



        /**
         * Hizufügen der Panels in das Main Grid Layout
         *
         * Es müssen vorers alle Komponenten eingetragen sein damit das richtige Layout dargestellt wird
         */

        JButton test4 = new JButton("Der letste Button in der letzten GridLayout-Zelle");

        
        this.add(border);
        this.add(flow);
        this.add(box);
        this.add(numbers);
        this.add(flow2);
        this.add(test4);
























    }

}
