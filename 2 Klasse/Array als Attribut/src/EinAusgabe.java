import java.util.Scanner;
public class EinAusgabe{

    public static void main(String[]args){
        System.out.println("Geben Sie die Anzahl der Stellen ein");
        Scanner sc =new Scanner(System.in);
        int anzahl = sc.nextInt();
        sc.close();
        ZahlenArray zahlenArray = new ZahlenArray(anzahl);
        zahlenArray.zufallsArray(anzahl);
        System.out.println(""+zahlenArray.getZahlen());
        System.out.println(zahlenArray.arrayToText());
        zahlenArray.umdrehen();
        
        
    }
}