import java.util.Arrays;

public class WortListe {

	private Worteintrag[] wortEinträge;

	public WortListe(Worteintrag eintrag){
		addWortEintrag(eintrag);
	}

	/**
	 *
	 * FEhlerhaft, wie mach ich die länge des Arrays passend?
	 * @param newEintrag
	 */
	public void addWortEintrag(Worteintrag newEintrag) {
		if(newEintrag == null)
			throw new IllegalArgumentException("Class WortListe  addWortEintrag: Kein Eintrag als Param");

		//Damit man was reinspeichern kann muss man das array erweitern, weil es am anfang keinen einzigen platz gibt
		if(wortEinträge == null){
			this.wortEinträge = new Worteintrag[1];
			this.wortEinträge[0] = newEintrag;
			this.wortEinträge = Arrays.copyOf(this.wortEinträge,2);
			return;
		}

		for(int i = 0; i < this.wortEinträge.length;i++){
			if(this.wortEinträge[i] == null){
				this.wortEinträge[i] = newEintrag;
				return;
			}


		}
	}

	public Worteintrag returnWortEintragElement(int stelleImArray) {
		if(stelleImArray > this.wortEinträge.length){
			throw new IllegalArgumentException("Class Wortliste returnWortEintragElement: Die stelleImArray war größer als das array");
		}
		if(stelleImArray <0)
			throw new IllegalArgumentException("Class Wortliste returnWorteintragElement: Die im parameter übergebene stelle ist negativ");

		return wortEinträge[stelleImArray];
	}

	public boolean deleteElementByParam(String deletedWord) {
		for(int i = 0; i < this.wortEinträge.length;i++){
			if(wortEinträge[i].getWort().equals(deletedWord)){
				wortEinträge[i].setWort("");
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String ausgabe ="";
		for(int i = 0; i < wortEinträge.length;i++){
			if(wortEinträge[i] != null){
				ausgabe += "Wort:" + wortEinträge[i].getWort() +"; URL: "+ wortEinträge[i].getUrl() +" \n ";
			}
		}
		return ausgabe;

	}

	public Worteintrag[] getWorteinträge() {
		return  null;
	}

}
