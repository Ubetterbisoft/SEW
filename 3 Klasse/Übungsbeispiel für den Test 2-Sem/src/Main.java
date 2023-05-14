/**
 * Rudimentäre Main-Klasse, die zum Ausprobieren der verschiedenen
 * Methoden verwendet werden kann (wird nicht bewertet)
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Ausprobieren gestartet");
		 
		Laptop i1 = new Laptop(445930202L,"HP");
		Switch s1 = new Switch(101928329L,24);
		
		PatchPanel inv = new PatchPanel(8);

		System.out.println("Ausprobieren beendet");
		
		System.out.println("JUnit-Tests ausführen:");
		RunTests.run();
	}

}