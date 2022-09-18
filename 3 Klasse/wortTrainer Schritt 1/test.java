public class test {

	public static void main(String[] args) {
		//ERstellt die Worteinträge
		Worteintrag DejanWorteintrag = new Worteintrag("Dejan"," https://dejan.com");
		Worteintrag RajicWorteintrag = new Worteintrag("Rajic"," https://dejan.com");
		Worteintrag TimoWorteintrag = new Worteintrag("Timo"," https://Timo.com");

		//ERstellt die Wortliste
		WortListe testWortListe = new WortListe(DejanWorteintrag);

		testWortListe.addWortEintrag(RajicWorteintrag);
		testWortListe.addWortEintrag(TimoWorteintrag);
		System.out.println(testWortListe.toString());


	}

}
