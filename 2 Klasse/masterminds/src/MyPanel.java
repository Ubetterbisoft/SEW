import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

/**
 * Ein JPanel, in BorderLayout
 * 
 * @author Walter Rafeiner-Magor
 * @version 2.3
 */
public class MyPanel extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 8005212575810267673L;
	//	Konstanten
	public final static int INPUT_FIELDS=5;
	public final static int COMMENT_ROWS=5;
	public final static int COMMENT_COLUMS=60;
//	Attribute
	private JTextField[] input;
	private JButton jbCheck,jbNew, jbSolve;
	private JTextArea jtaComment;
	private Kreise kreise;
	
	/**
	 * Konstruktor mit Controller-Klasse
	 * @param lc Controller
	 */
	public MyPanel(MyController lc) {
		this.setBackground(Color.YELLOW);
		this.setLayout(new BorderLayout());
		// north besteht nur aus einer Zeile
		JPanel north=new JPanel(new GridLayout(1, 5));
		input=new JTextField[INPUT_FIELDS];
		for(int i=0;i< input.length;i++){
			input[i]=new JTextField();
			input[i].addActionListener(lc);
			north.add(input[i]);
		}
		// center enthält (derzeit) nur den KOmmentar
		JPanel center=new JPanel(new GridLayout(2, 1));
		center.setOpaque(false);
		jtaComment=new JTextArea(COMMENT_ROWS,COMMENT_COLUMS);
		jtaComment.setEditable(false);
		jtaComment.setWrapStyleWord(true);
		DefaultCaret caret = (DefaultCaret)jtaComment.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jtaComment);
		center.add(scrollPane);
		// Kreise sind in der zweite Zeile in der Größe 30
		kreise=new Kreise(5,30);
		kreise.setOpaque(false);
		center.add(kreise);
		// south enthält alle Buttons
		JPanel south=new JPanel();
		south.setOpaque(false);
		jbCheck=new JButton("Überprüfen");
		jbCheck.addActionListener(lc);
		south.add(jbCheck);
		
		jbNew=new JButton("Neuer Versuch");
		jbNew.addActionListener(lc);
		south.add(jbNew);
		
		jbSolve=new JButton("Lösung");
		jbSolve.addActionListener(lc);
		south.add(jbSolve);
		
		// JPanel zusammensetzen
		this.add(BorderLayout.NORTH,north);
		this.add(BorderLayout.CENTER,center);
		this.add(BorderLayout.SOUTH, south);
		
	}
	/**
	 * Spiel initialisieren
	 */
	public void initialize(){
		jtaComment.setText("");
		for(int i=0;i<input.length;i++){
			input[i].setText("");
		}
		kreise.initialize();
	}
	// getter und setter
	/**
	 * @return the input
	 */
	public int[] getInput() {
		int[] ret=new int[INPUT_FIELDS];
		for(int i=0;i<INPUT_FIELDS;i++){
			ret[i]=0;
			try{
			ret[i]=Integer.parseInt(input[i].getText());
			}
			catch(NumberFormatException e){};
		}
		return ret;
	}
	/**
	 * @return the jbCheck
	 */
	public JButton getJbCheck() {
		return jbCheck;
	}
	/**
	 * @return the jbNew
	 */
	public JButton getJbNew() {
		return jbNew;
	}
	/**
	 * @return the jbSolve
	 */
	public JButton getJbSolve() {
		return jbSolve;
	}
	/**
	 * @return the jtaComment
	 */
	public JTextArea getJtaComment() {
		return jtaComment;
	}
	/**
	 * @param jtaComment the jtaComment to set
	 */
	public void addComment(String s) {
		StringBuilder sb=new StringBuilder();
		sb.append(jtaComment.getText());
		sb.append('\n');
		sb.append(s);
		this.jtaComment.setText(sb.toString());
	}
	/**
	 * aktualisiert die Kreise
	 * @param correct
	 * @param wrongPosition
	 */
	public void refreshKreise(int correct, int wrongPosition){
		kreise.refresh(correct, wrongPosition);
	}

} 
    

