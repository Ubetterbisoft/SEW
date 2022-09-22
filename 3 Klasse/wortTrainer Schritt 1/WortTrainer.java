public class WortTrainer {

	private WortListe wortListe;

	private Worteintrag worteintrag;

	public WortTrainer(){

	}

	public void setWortListe(WortListe wortListe) {

		this.wortListe = wortListe;
	}


	/**
	 * gibt ein zufälliges wort aus und speichert es im Attribut
	 * @return Worteintrag
	 */
	public Worteintrag randomWordSelection() {
		int wordlistlength = wortListe.getWorteinträge().length;
		int random =  (int) (Math.random() * (wordlistlength));
		worteintrag = wortListe.getWorteinträge()[random];
		return wortListe.getWorteinträge()[random];

	}

	/**
	 * Das letzte wort
	 * @return das zufällige wort aus dem attribut
	 */
	public Worteintrag returnRandomWord() {
		if(this.worteintrag != null){
			return worteintrag;
		}
		throw	new IllegalArgumentException("Class WortTrainer; Methode returnRandomWord(); randomword ist nicht festgelegt");

	}

	/**
	 * überprüft ob ein wortmit dem zufälligen wort aus dem Attribut übereinstimmt
	 * @param wort
	 * @return
	 */
	public boolean check(String wort) {
		if(wort.equals(this.worteintrag.getWort())){
			return true;
		}
		return false;
	}

	/**
	 * analog zu check ignoriert gros Klein
	 * @param wort
	 * @return
	 */
	public boolean checkIgnoreCase(String wort) {
		String wortKlein = wort.toLowerCase();
		String attributKlein = this.worteintrag.getWort().toLowerCase();
		if(wortKlein.equals(attributKlein)){
			return true;
		}
		return false;
	}

}
