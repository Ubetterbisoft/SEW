/**
 * Diese Klasse repräsentiert einen Spielchip, der entweder Gelb oder
 * Rot sein kann. Die Farben werden durch die öffentliche Konstanten
 * <code>Chip.GELB</code> und <code>Chip.ROT</code> dargestellt.
 * @author Lisa Vittori
 * @version 2021-11-21
 */
public class Chip {
	private String farbe;
	public static final String GELB = "Gelb";
	public static final String ROT = "Rot";
	
	/**
	 * Überprüft, ob ein übergebener Farb-String den in den Konstanten 
	 * <code>Chip.GELB</code> und <code>Chip.ROT</code> gespeicherten Werten
	 * entspricht.
	 * @param farbe der zu überprüftende Farbstring
	 * @return <code>true</code>, wenn der übergebene String den in den Konstanten
	 * <code>Chip.GELB</code> und <code>Chip.ROT</code> gespeicherten Werten
	 * entspricht, sonst <code>false</code>.
	 */
	public static boolean checkFarbe(String farbe) {
		if(farbe != null && (farbe.equals(Chip.GELB) || farbe.equals(Chip.ROT))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Speichert die übergebene Farbe als Attribut unter Verwendung von 
	 * <code>setFarbe(String farbe</code>). Wenn die übergebene Farbe
	 * ungültig ist, dann wird der Wert <code>Chip.GELB</code> gespeichert.
	 * @param farbe die als Attribut zu setzende Farbe
	 * @see checkFarbe(String farbe)
	 * @see setFarbe(String farbe)
	 */
	public Chip(String farbe) {
		if(!this.setFarbe(farbe)) {
			this.farbe = Chip.GELB;
		}
	}
	
	/**
	 * Speichert die übergebene Farbe als Attribut, wenn diese bei der Überprüfung
	 * mit <code>checkFarbe</code> <code>true</code> ergibt. 
	 * @param farbe die als Attribut zu setzende Farbe
	 * @return <code>true</code> , wenn die Überprüfung mit <code>checkFarbe</code> <code>true</code> 
	 * ergeben hat und die neue Farbe gesetzt wurde (sonst <code>false</code>) 
	 * @see checkFarbe(String farbe)
	 */
	public boolean setFarbe(String farbe) {
		if(Chip.checkFarbe(farbe)) {
			this.farbe = farbe;
			return true;
		}
		return false;
	}
	
	/**
	 * Liefert den gespeicherten Farbwert zurück
	 * @return den gespeicherten Farbwert
	 */
	public String getFarbe() {
		return this.farbe;
	}
	
	/**
	 * Liefert das erste Zeichen des gespeicherten Farbwerts
	 * @return das erste Zeichen des gespeicherten Farbwerts
	 */
	public char getDisplayCharacter() {
		return this.farbe.charAt(0); 
	}
	
	/**
	 * Vergleicht die Farbwerte des übergebenen Chips mit dem
	 * aktuellen Chip (this) und gibt <code>true</code> zurück,
	 * wenn sie übereinstimmen
	 * @param c der Chip mit dem der aktuelle Chip (this) verglichen wird.
	 * @return <code>true</code> zurück, wenn die Farbwerte de aktuellen Chips 
	 * (this) und des übergebenen Chips übereinstimmen (sonst <code>false</code>) 
	 */
	public boolean equals(Chip c) {
		if(c == null) {
			return false;
		}
		if(this == c) {
			return true;
		}
		return this.farbe.equals(c.getFarbe());
	}
	
	/**
	 * Erzeugt ein neues Chip-Objekt mit dem gleichen Farbwert, wie das
	 * aktuelle Chip-Objekt (this) und gibt es zurück.
	 * @return ein neues Chip-Objekt mit dem gleichen Farbwert, wie das
	 * aktuelle Chip-Objekt (this).
	 */
	public Chip clone() {
		return new Chip(this.farbe);
	}
}
