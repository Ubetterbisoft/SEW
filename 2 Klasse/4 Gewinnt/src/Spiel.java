import java.util.Scanner;
/**
 * Vier gewinnt mit 2 Spielern
 * @author Dejan Rajic
 * @version 2022-01-15
 */
public class Spiel {
    /**
     * Mainmethode von der Spielklasse
     * @param args das argument
     */
    public static void main(String[] args) {
        System.out.println("Willkommen bei Vier Gewinnt!");

        VierGewinnt spiel = new VierGewinnt();
        String farbe;
        String gewinner;
        String weiterEingabe;

        Scanner scanner = new Scanner(System.in);
        int spaltenEingabe = -1, aktuelleZeile = -1;
        boolean eingabeBool;
        // Die Schleife wird für mehrere Spielrunden verwendet
        do {    
            gewinner = "";
            spiel.deleteAll(Chip.GELB);
            spiel.deleteAll(Chip.ROT);
            for(int durchgang = 1; durchgang <= 1000; durchgang++) {  // Schleife für die Spielrunden
                //überprüfung bei welchem durchgang welcher spieler dran ist
                farbe = durchgang % 2 == 1 ? Chip.ROT : Chip.GELB;
                Chip aktuellerChip = new Chip(farbe);
                System.out.println("\n\n***Durchgang " + durchgang + "***\nSpieler " + farbe + " ist dran");
                System.out.println(spiel.anzeige());
                System.out.println("Werfen Sie Ihren Chip in eine Spalte (1-7) ein");
                eingabeBool = false;
                do {    // Schleife für die Spalteneingabe
                    if(scanner.hasNextInt()) {
                        spaltenEingabe = scanner.nextInt();
                        //Der eingabebereich wird geprüft
                        if(spaltenEingabe >= 1 && spaltenEingabe <= 7) {
                            spaltenEingabe--;
                            aktuelleZeile = spiel.add(spaltenEingabe, aktuellerChip);
                            //Wenn die Spalte voll ist kann man nichts reinfüllen
                            if(aktuelleZeile == -1)
                                System.out.println("Die Spalte ist bereits voll gefüllt.\nBitte gbefüllen Sie eine andere Spalte");
                            else
                                eingabeBool = true;
                        }
                        else {
                            System.out.println("Es können nur Spalten zwischen 1 und 7 gewählt werden.\nBitte geben Sie eine gültige Spalte ein:");
                        }
                    }
                    else {
                        System.out.println("Das ist keine gültige Spalte.\nBitte geben Sie eine gültige Spalte ein:");
                    }
                    scanner.nextLine();
                } while (!eingabeBool);
                //Der Gewinner wird bestimmt
                if(spiel.checkGewinn(aktuelleZeile, spaltenEingabe)) {
                    System.out.println(spiel.anzeige());
                    gewinner = farbe;
                    break;
                }
            }
            //Die Gewinnerbenachrichtigung wird ausgegeben
            System.out.println("\n");
            if(gewinner.equals(Chip.ROT))
                System.out.println("Spieler Rot hat gewonnen. Herzlichen Glückwunsch!");
            if(gewinner.equals(Chip.GELB))
                System.out.println("Spieler Gelb hat gewonnen. Herzlichen Glückwunsch!");
            if(gewinner.equals(""))
                System.out.println("Unentschieden!");

            System.out.println("\n\nLust auf eine weitere Runde? (j/N)");
            weiterEingabe = scanner.nextLine();
        } while (weiterEingabe.toLowerCase().equals("j") || weiterEingabe.toLowerCase().equals("ja"));
        scanner.close();
    }
}
