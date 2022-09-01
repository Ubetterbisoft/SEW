import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Kreise extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	Konstanten
	public final static Color CORRECT=Color.BLACK;
	public final static Color INCORRECT=Color.LIGHT_GRAY;
	public final static Color WRONG_POSITION=Color.WHITE;
	public final static int MARGIN_TOP=5;
	public final static int MARGIN_LEFT=5;
	public final static int ANZAHL=5;
	public final static int SIZE=10;
	
//	Attribute
	private int anzahl;
	private int size;
	private Color[] values;
	
	public Kreise(){
		this(ANZAHL,SIZE);
	}
	public Kreise(int anzahl){
		this(anzahl,SIZE);
	}
	public Kreise(int anzahl,int size){
		this.anzahl=anzahl;
		this.size=size;
		values=new Color[anzahl];
		initialize();
	}
	
	public void initialize(){
		for(int i=0;i<anzahl;i++)
			values[i]=INCORRECT;
		this.repaint();
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int marginTop=MARGIN_TOP;
		int marginLeft=MARGIN_LEFT;
		for (int i=0;i<anzahl;i++){
			g.setColor(values[i]);
			g.fillOval(marginLeft, marginTop, size, size);
			//schwarzer Rand
			g.setColor(Color.BLACK);
			g.drawOval(marginLeft, marginTop, size, size);
			marginLeft=marginLeft+size+MARGIN_LEFT;
		}
	}
	 
	public void refresh(int correct, int wrongPosition){
		initialize();
		int i=0;
		while(--correct>=0)
			values[i++]=CORRECT;
		while(--wrongPosition>=0)
			values[i++]=WRONG_POSITION;
		repaint();
	}	
}