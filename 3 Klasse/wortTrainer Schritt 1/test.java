public class test {

	public static void main(String[] args) {
		//ERstellt die Worteinträge
		Worteintrag DejanWorteintrag = new Worteintrag("Dejan"," https://dejan.com");
		Worteintrag RajicWorteintrag = new Worteintrag("Rajic"," https://dejan.com");
		Worteintrag TimoWorteintrag = new Worteintrag("Timo"," https://Timo.com");

		//ERstellt die Wortliste
		WortListe testWortListe = new WortListe();

		testWortListe.addWortEintrag(RajicWorteintrag);
		testWortListe.addWortEintrag(TimoWorteintrag);
		testWortListe.addWortEintrag(DejanWorteintrag);

		System.out.println(testWortListe.toString());
		System.out.println(testWortListe.returnWortEintragElement(1));
		System.out.println(testWortListe.deleteElementByParam("Dejan"));
		System.out.println(testWortListe.toString());

		WortTrainer wortTrainer = new WortTrainer();
		wortTrainer.setWortListe(testWortListe);
		System.out.println("Random: \n"+wortTrainer.randomWordSelection());


	}

}
