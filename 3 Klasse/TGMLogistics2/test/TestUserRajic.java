import TGMLogistics.User.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserRajic {
    @Test
    @DisplayName("U01 - Der Passwort-Check wird abgebrochen, wenn ein null-Wert übergeben wird")
    void abbruchWennNull() {
        assertThrows(IllegalArgumentException.class, () -> UserRajic.checkPasswordStrength(null),
                "IllegalArgumentException wird nicht geworfen");
    }

    @Test
    @DisplayName("U02 - Die Passwortstärke beträgt bei Passwörtern kürzer als 8 Zeichen 0")
    void kuerzer8Z() {
        assertEquals(0, UserRajic.checkPasswordStrength("abcdef"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U03 - Die Passwortstärke beträgt bei jedem Passwort kürzer als 8 Zeichen inkl. jene, die viele Zeichengruppen beinhalten, immer 0")
    void kuerzer8ZVieleZeichengruppen() {
        assertEquals(0, UserRajic.checkPasswordStrength("aB12äö!"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U04 - Die Passwortstärke jedes Passworts länger als 15 Zeichen beträgt mind. 1.")
    void laenger15() {
        assertEquals(1, UserRajic.checkPasswordStrength("aaaaaaaaaaaaaaaaa"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U05 - Die Passwortstärke jedes komplexeren Passworts länger als 15 Zeichen beträgt mindestens 3")
    void laenger15Komplex() {
        assertEquals(2, UserRajic.checkPasswordStrength("abcdefghijklmno123"), "Passwortstärke falsch");
        assertEquals(5, UserRajic.checkPasswordStrength("abcABC123äöü€@%!"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U06 - Die Passwortstärke jedes Passworts mit mind. 8 Zeichen und 4 Zeichengruppen beträgt mind. 3")
    void min8Z4G() {
        assertEquals(3, UserRajic.checkPasswordStrength("abcABC123!?"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U07 - Die Passwortstärke jedes Passworts länger als 15 Zeichen und 4 Zeichengruppen beträgt 4")
    void laenger15Z4G() {
        assertEquals(4, UserRajic.checkPasswordStrength("abcxyzABCXYZ12345!?"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U08 - Die Passwortstärke jedes Passworts mit 8-15 Zeichen und allen Zeichengruppen, wobei von mind. einer nur ein Zeichen vorhanden ist, beträgt max. 3")
    void l8k15alleG() {
        assertEquals(3, UserRajic.checkPasswordStrength("abcABC12ü!"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U09 - Die Passwortstärke jedes Passworts länger als 15 Zeichen und allen Zeichengruppen, wobei von mind. einer nur ein Zeichen vorhanden ist, beträgt max. 4")
    void laenger15alleG() {
        assertEquals(4, UserRajic.checkPasswordStrength("abcdABCD1234äöü!"), "Passwortstärke falsch");
    }

    @Test
    @DisplayName("U10 - Die Passwortstärke jedes Passworts, das 15 Zeichen lang ist und aus 2 Zeichengruppen besteht, wobei aus einer der beiden nur 2 Zeichen genommen werden, beträgt 0")
    void Z15G2() {
        assertEquals(1, UserRajic.checkPasswordStrength("abcdefghijklmAB"), "Passwortstärke falsch");
    }
}
