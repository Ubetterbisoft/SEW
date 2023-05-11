import TGMLogistics.Exceptions.NoValidEmailException;
import TGMLogistics.Exceptions.NoValidPhoneNumberException;
import TGMLogistics.Exceptions.PasswordTooWeakException;
import TGMLogistics.Helper.Address;
import TGMLogistics.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import TGMLogistics.User.UserPrivilege;
import static org.junit.jupiter.api.Assertions.*;
public class TestClass {
    private User user;
    @BeforeEach
    void setup(){
        Address address = new Address("Musterstrasse",1,"Wien","Austria",1010);
        try {
            this.user = new User(UserPrivilege.ADMIN,"Max","Muster","+4367712341234","maxmuster@tgm.ac.at","XA#*<TGM>b34y",address);

        } catch (NoValidEmailException e) {
            throw new RuntimeException(e);
        } catch (NoValidPhoneNumberException e) {
            throw new RuntimeException(e);
        } catch (PasswordTooWeakException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Ein Benutzer wird korrekt angelegt")
    @Test
    void testen(){
        //Attribut des Konstruktors wird mit musterwert verglichen
        assertEquals("Musterstrasse",user.getUserAddress().getStreetName(),"Straßenname Falsch in address");
        //Das muss für alle attribute wiederholt werden um sie zu vergleichen

        //Überprüfung der Adressdaten
        assertEquals(1,user.getUserAddress().getStreetNumber(),"Falsche Hausnummer in address");
        assertEquals("Wien",user.getUserAddress().getCity(),"Falsche Stadt in address");
        assertEquals("Austria",user.getUserAddress().getState(),"Falsches Land in address");
        assertEquals(1010,user.getUserAddress().getPostcode(),"Falsche Postleitzahl in address" );

        assertEquals("Max", user.getFirstName(),"Falscher Vorname in user");
        assertEquals("Muster",user.getLastName(),"Falscher Nachname in user");
        assertEquals("+4367712341234",user.getPhone(),"Falsche Telefonnummer in User");
        assertEquals("maxmuster@tgm.ac.at",user.getEmail(),"Falsche Email in User");


    }
}
