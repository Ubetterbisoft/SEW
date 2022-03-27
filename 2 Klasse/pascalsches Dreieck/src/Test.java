
import java.util.Scanner;

public class Test {

/**
 * Testet die Methoden der Klasse PascalschesDreieck.
 * @author Rajic Dejan
 * @version 17.01.2022
 */

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        System.out.println("Anzahl der Zeilen: ");
        int x = eingabe.nextInt();
        eingabe.close();
        
        int[][] array = PascalschesDreieck.pascal(x);

        System.out.println("Das gewünschte Pascalsche Dreieck:");
        System.out.print(PascalschesDreieck.arrayToString(array));
        
    }

}
