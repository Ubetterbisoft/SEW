import TGMLogistics.Exceptions.NoValidEmailException;
import TGMLogistics.Exceptions.NoValidPhoneNumberException;
import TGMLogistics.Exceptions.PasswordTooWeakException;
import TGMLogistics.Helper.Address;
import TGMLogistics.User.User;
import TGMLogistics.User.UserPrivilege;

/**
 * Definiert userPasswordStrength neu, sodass die Passwortstärke richtig gemessen werden kann
 * @author Dejan Rajic
 * @version 2023-04-29<hk b
 */
public class UserRajic extends User {
    public static final String KLEINBUCHSTABEN = "abcdefghijklmnopqrstuvwxyz";
    public static final String GROSSBUCHSTABEN = KLEINBUCHSTABEN.toUpperCase();
    public static final String ZIFFERN = "0123456789";
    public static final String SONDERZEICHEN = "$%-.,;:!?@+#*=()";
    public static final String UMLAUTE = "äöüÄÖÜß";

    public UserRajic(UserPrivilege privilege, String first, String last, String phone, String mailStr, String pw, Address addr) throws NoValidEmailException, NoValidPhoneNumberException, PasswordTooWeakException {
        super(privilege, first, last, phone, mailStr, pw, addr);
    }

    /**
     * Zählt wie oft ein Zeichen aus b in a vorkommt
     * @param a String a
     * @param b String b
     * @return die Anzahl, wie of ein Zeichen aus b in a vorkommt
     */
    private static int containsAny(String a, String b) {
        int anzahl = 0;
        for(int i = 0; i < b.length(); i++) {
            if(a.contains(Character.toString(b.charAt(i))))
                anzahl++;
        }
        return anzahl;
    }

    /**
     * Testet die Stärke eines übergebenen Passworts nach bestimmten Kriterien.
     * @param pw Das zu überprüfende Passwort
     * @return Die Stärke des Passworts
     */
    public static int checkPasswordStrength(String pw) {
        if(pw == null) throw new IllegalArgumentException("Für Passwort muss ein Wert angegeben werden!");

        String[] zeichengruppen = {GROSSBUCHSTABEN, KLEINBUCHSTABEN, ZIFFERN, SONDERZEICHEN, UMLAUTE};

        if(pw.length() < 8) return 0;

        int staerke = 1;
        if(pw.length() > 15) staerke++;

        int anzahlGruppen = 0;
        int niedrigsteAnzahl = 10;
        for(String zeichengruppe : zeichengruppen) {
            int anzahl = containsAny(pw, zeichengruppe);
            if(anzahl > 0) {
                anzahlGruppen++;
                if(anzahl < niedrigsteAnzahl) niedrigsteAnzahl = anzahl;
            }
        }
        if(anzahlGruppen > 2) staerke += anzahlGruppen - 2;
        if(niedrigsteAnzahl < 2) staerke--;

        return staerke;
    }
}
