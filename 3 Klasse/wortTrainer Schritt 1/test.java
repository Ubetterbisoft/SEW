/**
 * testet alle funktionen
 * @author draji
 * @version 2022.09.22
 */
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
		System.out.println("Random: \n"+wortTrainer.randomWordSelection());
		System.out.println("RandomReturn:" + wortTrainer.returnRandomWord());
		System.out.println("CheckAttribut:" + wortTrainer.check("Raajic"));

		System.out.println("CheckIgnoreCase:" + wortTrainer.checkIgnoreCase("rajic"));

		System.out.println("#############################################################################");
		wortTrainer.checkIgnoreCase("Dejan");
		wortTrainer.check("Rajic");
		wortTrainer.check("Rajic");
		System.out.println(wortTrainer.statistik());

	}

}
