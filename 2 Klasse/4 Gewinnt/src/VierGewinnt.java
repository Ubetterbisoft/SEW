/**
 * Repräsentiert ein Vier Gewinnt Spielbrett
 * @author Dejan Rajic
 * @version 2022-15-01
 */
public class VierGewinnt {

	private Chip[][] spielbrett;

	/**
	 * Erzeugt eine Vier Gewinnt Spielbrett mit 6 Zeilen und 7 Spalten
	 */
	public VierGewinnt() {
		this(6, 7);
	}

	/**
	 * Erzeugt ein Vier Gewinnt Spielbrett
	 * @param zeilen Anzahl an Zeilen des Spielbretts
	 * @param spalten Anzahl an Spalten des Spielbretts
	 */
	public VierGewinnt(int zeilen, int spalten) {
		if(zeilen > 0 && spalten > 0)
			this.spielbrett = new Chip[zeilen][spalten];
		else
			this.spielbrett = new Chip[6][7];
	}

	/**
	 * Erzeugt ein Vier Gewinnt Spielbrett
	 * @param spielbrett ein vorgegebenes Spielbrett
	 */
	public VierGewinnt(Chip[][] spielbrett) {
		if(spielbrett != null) {
			this.spielbrett = spielbrett;
		}
	}

	/**
	 * Gibt das aktuelle Spielbrett zurück
	 * @return aktuelles Spielbrett
	 */
	public Chip[][] getSpielbrett() {
		return this.spielbrett;
	}

	/**
	 * Fügt einen Chip in eine Spalte hinzu
	 * @param spalte Index der Spalte
	 * @param chip Chip der hizugefügt wird
	 * @return Zeilenindex, bei dem der Chip hinzugefügt wurde
	 */
	public int add(int spalte, Chip chip) {
		if(spalte < 0 || spalte >= this.spielbrett[0].length || chip == null)
			return -1;
		
		for(int zeile = this.spielbrett.length - 1; zeile >= 0; zeile--) {
			if(this.spielbrett[zeile][spalte] == null) {
				this.spielbrett[zeile][spalte] = chip;
				return zeile;
			}
		}
		return -1;
	}

	/**
	 * Fügt einen Chip in eine Spalte hinzu
	 * @param spalte Index der Spalte
	 * @param farbe Farbe des Chips, der hinzugefügt wird
	 * @return Zeilenindex, bei dem der Chip hinzugefügt wurde
	 */
	public int add(int spalte, String farbe) {
	
		if(!Chip.checkFarbe(farbe))
			return -1;

		return add(spalte, new Chip(farbe));
	}

	/**
	 * Gibt das aktuelle Spielbrett visualisiert als Text zurück
	 * @return das aktuelle Spielbrett als String
	 */
	public String anzeige() {
		String feld = "", zeilenAbgrenzung = "+---", leer = "|   ", rot = "| R ", gelb = "| G ";

		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < this.spielbrett[zeile].length; spalte++){
				feld += zeilenAbgrenzung;
			}
			feld += "+\n";
			for(int spalte = 0; spalte < this.spielbrett[zeile].length; spalte++){
				Chip aktuellerChip = this.spielbrett[zeile][spalte];
				if(aktuellerChip == null)
					feld += leer;
				if(aktuellerChip != null && aktuellerChip.getFarbe() == Chip.ROT)
					feld += rot;
				if(aktuellerChip != null && aktuellerChip.getFarbe() == Chip.GELB)
					feld += gelb;
			}
			feld += "|\n";
		}
		for(int spalte = 0; spalte < this.spielbrett[0].length; spalte++){
			feld += zeilenAbgrenzung;
		}
		feld += "+\n";

		return feld;
	}

	/**
	 * Überprüft, ob ausgehend vom angegebenen Chip eine Gewinnsituation besteht (horizontal und vertikal)
	 * @param zeile Zeileinindex des Chips
	 * @param spalte Spaltenindex des Chips
	 * @return ob eine Gewinnsituation besteht
	 */
	public boolean checkGewinn(int zeile, int spalte) {
		if(zeile < 0 || zeile >= this.spielbrett.length ||
			spalte < 0 || spalte >= this.spielbrett[0].length ||
			this.spielbrett[zeile][spalte] == null)
			return false;
		
		String chipFarbe = this.spielbrett[zeile][spalte].getFarbe();

		int anzahlChips = 1;
		for(int z = zeile + 1; z < this.spielbrett.length; z++) {
			if(this.spielbrett[z][spalte] != null && this.spielbrett[z][spalte].getFarbe() == chipFarbe)
				anzahlChips++;
			else
				break;
		}
		if(anzahlChips >= 4)
			return true;
		
		anzahlChips = 1;
		for(int s = spalte + 1; s < this.spielbrett[zeile].length; s++) {
			if(this.spielbrett[zeile][s] != null && this.spielbrett[zeile][s].getFarbe() == chipFarbe)
				anzahlChips++;
			else
				break;
		}
		for(int s = spalte - 1; s >= 0; s--) {
			if(this.spielbrett[zeile][s] != null && this.spielbrett[zeile][s].getFarbe() == chipFarbe)
				anzahlChips++;
			else
				break;
		}
		return anzahlChips >= 4;
	}

	/**
	 * Löscht den obersten Chip in der angegebenen Spalte
	 * @param spalte Spalte in der der Chip gelöscht wird
	 * @return ob der Chip erfolgreich gelöscht wurde
	 */
	public boolean deleteLast(int spalte) {
		if(spalte < 0 || spalte >= this.spielbrett[0].length)
			return false;
		
		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			if(this.spielbrett[zeile][spalte] != null) {
				this.spielbrett[zeile][spalte] = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Setzt einen Chip auf eine bestimmte Position
	 * @param zeile Zeile, in die der Chip gesetzt wird
	 * @param spalte Spalte, in die der Chip gesetzt wird
	 * @param chip Chip, der auf die Position gesetzt wird
	 * @return ob der Chip erfolgreich gesetzt wurde
	 */
	public boolean set(int zeile, int spalte, Chip chip) {
		if(zeile < 0 || zeile >= this.spielbrett.length ||
			spalte < 0 || spalte >= this.spielbrett[0].length ||
			this.spielbrett[zeile][spalte] != null ||
			chip == null)
			return false;
		this.spielbrett[zeile][spalte] = chip;
		return true;
	}

	/**
	 * Löscht alle Chips einer Farbe
	 * @param farbe Farbe der Chips, die gelöscht werden
	 */
	public void deleteAll(String farbe) {
		if(!Chip.checkFarbe(farbe)) 
			return;
		
		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < this.spielbrett[zeile].length; spalte++) {
				if(this.spielbrett[zeile][spalte] != null && this.spielbrett[zeile][spalte].getFarbe() == farbe)
					this.spielbrett[zeile][spalte] = null;
			}
		}
	}

	/**
	 * Vergleicht ein anderes Spielbrett mit diesem
	 * @param spielbrett das Spielbrett mit dem verglichen wird
	 * @return ob das Spielbrett das gleiche ist
	 */
	public boolean equals(VierGewinnt spielbrett) {
		if(spielbrett == null)
			return false;
		Chip[][] sb = spielbrett.getSpielbrett();
		if(this == spielbrett || this.spielbrett == sb)
			return true;
		if(sb == null || this.spielbrett == null || sb.length != this.spielbrett.length || sb[0].length != this.spielbrett[0].length)
			return false;
		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < this.spielbrett[0].length; spalte++) {
				if(this.spielbrett[zeile][spalte] != sb[zeile][spalte] && this.spielbrett.equals(sb))
					return false;
			}
		}
		return true;
	}

	/**
	 * Erstellt eine tiefe Kopie des Spielbretts
	 * @return die Kopie des Spielbretts
	 */
	public VierGewinnt clone() {
		Chip[][] kopie = new Chip[this.spielbrett.length][this.spielbrett[0].length];
		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < this.spielbrett[0].length; spalte++) {
				if(this.spielbrett[zeile][spalte] != null) {
					kopie[zeile][spalte] = this.spielbrett[zeile][spalte].clone();
				}
			}
		}
		return new VierGewinnt(kopie);
	}

}
