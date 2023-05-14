import java.util.SortedSet;
public class Main {
    public static void main(String[] args) {

        Schueler schueler = new Schueler(18, "Dejan", "Rajic", 'A');
        /**
         * Testen der spezifischen Methoden
         */
        System.out.println(schueler.notenListe());
        System.out.println(schueler.note(Gegenstand.SYT));
        schueler.noteHinzu(Gegenstand.SYT, 1);
        System.out.println(schueler.notenListe());
        System.out.println(schueler.note(Gegenstand.SYT));

        Schueler schueler1 = new Schueler(18, "Dejan", "Rajic", 'A');


        //Testen der Equals Methode
        System.out.println("Equals: " + schueler.equals(schueler1));
        System.out.println(schueler.hashCode() == schueler1.hashCode());
        //Testen der compareTo Methode
        System.out.println("CompareTo: " + schueler.compareTo(schueler1));
        System.out.println("notenGelistet: " + schueler.notenGelistet());


    }
}