import java.time.*;
/**
 * Feiertagsrechner berechnet die Feiertage
 * @author Rajic Dejan
 * @version 2020-01-20
 */
public class Feiertagsrechner {
    public static void main(String[]args) {
        
        LocalDate geburtstag1 = LocalDate.of(2006,1,30);
        System.out.println("Mein Geburtsdatum: "+geburtstag1);

        LocalDate geburtstagHeuer = LocalDate.of(2022,1,30);
        System.out.println("Mein Geburtsdatum(heuer): "+geburtstagHeuer);

        LocalDate now = LocalDate.now();

        Period p = Period.between(geburtstagHeuer,now);
        int monat = p.getMonths();
        int tag = p.getDays();
        System.out.println("Die Zeit, die seit meinem Geburtstag vergangen ist: "+monat+" Monate und "+tag+" Tage");

        LocalDate nächstesJahr = LocalDate.of(2023,1,30);
        Period p2 = Period.between(now,nächstesJahr);
        int jahr = p2.getYears();
        int monat2 = p2.getMonths();
        int tag2 = p2.getDays();
        System.out.println("Die Zeit, die ich noch bis zu meinem Geburtstag im nächsten Jahr warten muss: "+jahr+" Jahr/e "+monat2+" Monate und "+tag2+" Tage");


        LocalDate geburtstag2 = LocalDate.of(2000,1,1);
        Period p3 = Period.between(geburtstag2,now);
        System.out.println("Wieviele Jahre seit meinem Geburtstag und dem heutigen Tag vergangen sind (Beispiel): "+p3.getYears());
        
        System.out.println("Mein Geburtsdatum(heuer): "+geburtstagHeuer+", "+wochentag(30,1,2022));

        LocalDate l = LocalDate.of(2022,1,30);
        String s = wochentag(30,1,2023);
        System.out.println("Mein Geburtsdatum(nächstes Jahr): "+l+", "+s);
    }







    /**
     * Die Methode gibt den Wochentag zurück
     * @param tag der Tag
     * @param monat der Monat
     * @param jahr das Jahr
     * @return wochentag gibt den Wochentag zurück
     */
    public static String wochentag(int tag, int monat, int jahr) {
        String wochentag="";
        if(monat<=2) {
            monat+=10;
            jahr-= 1;
        }
        else {
            monat-= 2;
        }
        int a= jahr/100;
        int b= jahr%100;
        int c= ((26*monat-2)/10+tag+b+b/4+a/4-2*a)%7;
        if(c<0) c+=7;
        switch(c) {
            case 0:
                wochentag= "Sonntag";
                break;
            case 1:
                wochentag="Montag";
                break;
            case 2:
                wochentag="Dienstag";
                break;
            case 3:
                wochentag="Mittwoch";
                break;
            case 4:
                wochentag="Donnerstag";
                break;
            case 5:
                wochentag="Freitag";
                break;
            case 6:
                wochentag="Samstag";
                break;
            case 7:
                wochentag="Sonntag";
                break;
        }
        return wochentag;
    }
}