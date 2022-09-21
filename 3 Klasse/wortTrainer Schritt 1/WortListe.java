import java.util.Arrays;

public class WortListe {

	private Worteintrag[] wortEinträge;

	public WortListe(){

		wortEinträge = new Worteintrag[1];
	}

	/**
	 *
	 * FEhlerhaft, wie mach ich die länge des Arrays passend?
	 * @param newEintrag
	 */
	public void addWortEintrag(Worteintrag newEintrag) {
		if(newEintrag == null)
			throw new IllegalArgumentException("Class WortListe  addWortEintrag: Kein Eintrag als Param");


		/**
		 * Geht die gesammte wortListe durch, wenn sie voll ist wird auserhalb der Schleife
		 * das Array erweitert. Danach wird es ohne abfrage reingespeichert weil es 100% reinpasst
		 */
		int i = 0;
		for(; i < wortEinträge.length;i++){
			//Wenn eine stelle frei ist, speicher Eintrag rein
			if(wortEinträge[i] == null) {
				wortEinträge[i] = newEintrag;
				return;
			}
		}

		//mit i+1 erweitern, will ja eine stelle größer haben
		wortEinträge = Arrays.copyOf(wortEinträge,i+1);
		//nur [i] ansprechen index zählt ab 0
		wortEinträge[i] = newEintrag;




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
				wortEinträge = removeTheElement(wortEinträge,i);


				return true;
			}
		}
		return false;
	}

	/**
	 * löscht eine Stelle aus der Wortliste
	 * @param arr
	 * @param index
	 * @return
	 */
	public Worteintrag[] removeTheElement(Worteintrag[] arr, int index)
	{

		// If the array is empty
		// or the index is not in array range
		// return the original array
		if (arr == null || index < 0
				|| index >= arr.length) {

			return arr;
		}

		// Create another array of size one less
		Worteintrag[] anotherArray = new Worteintrag[arr.length - 1];

		// Copy the elements except the index
		// from original array to the other array
		for (int i = 0, k = 0; i < arr.length; i++) {

			// if the index is
			// the removal element index
			if (i == index) {
				continue;
			}

			// if the index is not
			// the removal element index
			anotherArray[k++] = arr[i];
		}

		// return the resultant array
		return anotherArray;
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
		return  wortEinträge;
	}

}
