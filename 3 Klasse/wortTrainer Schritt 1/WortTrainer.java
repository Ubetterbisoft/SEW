public class WortTrainer {

	private WortListe wortListe;

	private Worteintrag worteintrag;

	public WortTrainer(){

	}

	public void setWortListe(WortListe wortListe) {
		this.wortListe = wortListe;
	}



	public Worteintrag randomWordSelection() {
		int wordlistlength = wortListe.getWorteinträge().length;
		int random =  (int) Math.random() * (wordlistlength  +1);
		return wortListe.getWorteinträge()[random];

	}

	public String returnRandomWord() {
		return null;
	}

	public boolean check(String wort) {
		return false;
	}

	public boolean checkIgnoreCase(String wort) {
		return false;
	}

}
