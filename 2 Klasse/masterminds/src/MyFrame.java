import java.awt.*;

import javax.swing.*;
/**
 * Die Klasse Zeichnung stellt als Zeichenfläche
 * ein JPanel in einem JFrame zur Verfügung.
 *
 * @author Walter Rafeiner-Magor
 * @version 2.3
 */
public class MyFrame extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5625118420600493902L;
	private JMenuItem itemNew;					// Neues Spiel erzeugen
	private JMenuItem itemTest;					// Werte Testem
	private JMenuItem itemSolve;				// Lösung darstellen
	private JMenuItem itemAbout;				// About
	private JMenuItem itemHelp;					// Hilfe
	
    /**
     * Konstruktor
     * @param view	MyJPanel
     * @param lc	Controller-Klasse
     */
    public MyFrame(MyPanel view,MyController lc)
    {
    	super("Mastermind");					// Titel gesetzt    
    	JMenuBar menuBar=new JMenuBar();		// MenuBar erstellt
    	//////////////////////////////////
    	// erstes Menü: Datei
    	JMenu menuGame=new JMenu("Game");
    	//// Menüeintrag: New
       	itemNew=new JMenuItem("New",'N');
       	itemNew.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
       	itemNew.addActionListener(lc);		// Listener anmelden
       	menuGame.add(itemNew);				// zum Menü hinzufügen
       	//// Menüeintrag: Laden
    	itemTest=new JMenuItem("Test...");
    	itemTest.setAccelerator(KeyStroke.getKeyStroke('T',
    			Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
    	itemTest.addActionListener(lc);		// Listener anmelden
    	menuGame.add(itemTest);				// zum Menü hinzufügen
       	//// Menüeintrag: Speichern
    	itemSolve=new JMenuItem("Solve...");
    	itemSolve.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
    	itemSolve.addActionListener(lc);		// Listener anmelden
    	menuGame.add(itemSolve);				// zum Menü hinzufügen
    	menuBar.add(menuGame);
    	

    	//////////////////////////////////
    	// lezttes Menü: About    	    	
    	JMenu menuInfo=new JMenu("Info");    	
    	//// Menüeintrag: Help    	
    	itemHelp=new JMenuItem("Help");
    	itemHelp.addActionListener(lc);			// Listener anmelden
    	menuInfo.add(itemHelp);					// zum Menü hinzufügen
    	menuBar.add(Box.createHorizontalGlue());// Menü rechtsbündig einfügen
    	menuBar.add(menuInfo);					// zur MenuBar hinzufügen
    	//// Menüeintrag: Info    	
    	itemAbout=new JMenuItem("About");
    	itemAbout.addActionListener(lc);			// Listener anmelden
    	menuInfo.add(itemAbout);					// zum Menü hinzufügen
    	menuBar.add(menuInfo);					// zur MenuBar hinzufügen
    	this.setJMenuBar(menuBar);				// MenuBar im JFrame setzen
    	
        this.add(view);				// MyJPanel Im Center verankert
//        this.setSize(800,600);		// Startgröße festgelegt
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 		// Zentrieren
        this.setVisible(true);		// Fenster nun sichtbar
   }
   
    ///////GETTER  und SETTER //////////////
	/**
	 * @return the itemInfo
	 */
	public JMenuItem getItemAbout() {
		return itemAbout;
	}

	/**
	 * @return the itemLoad
	 */
	public JMenuItem getItemTest() {
		return itemTest;
	}
	/**
	 * @return the itemSave
	 */
	public JMenuItem getItemSolve() {
		return itemSolve;
	}
	/**
	 * @return the itemNew
	 */
	public JMenuItem getItemNew() {
		return itemNew;
	}
	/**
	 * @return the itemHelp
	 */
	public JMenuItem getItemHelp() {
		return itemHelp;
	}

} 