import TGMLogistics.Exceptions.*;
import TGMLogistics.Helper.Address;
import TGMLogistics.Item.ClothingSize;
import TGMLogistics.Item.Item;
import TGMLogistics.Item.Shirt;
import TGMLogistics.OrderLogistics.LogisticsSystem;
import TGMLogistics.OrderLogistics.Order;
import TGMLogistics.OrderLogistics.OrderStatus;
import TGMLogistics.Store.Store;
import TGMLogistics.User.PaymentMethod;
import TGMLogistics.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import TGMLogistics.User.UserPrivilege;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestClass {
    private User user;
    private User user2;
    private User user3;
    private Shirt shirt1;
    private Shirt shirt2;
    private Shirt shirt3;
    private Order order1;
    private Order order2;
    private Order order3;
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
        try {
            this.user2 = new User(UserPrivilege.CUSTOMER,"Anna","Muster","+4367712341234","maxmuster@tgm.ac.at","XA#*<TGM>b34y",address);
        } catch (NoValidEmailException e) {
            throw new RuntimeException(e);
        } catch (NoValidPhoneNumberException e) {
            throw new RuntimeException(e);
        } catch (PasswordTooWeakException e) {
            throw new RuntimeException(e);
        }
        try {
            this.user3 = new User(UserPrivilege.COWORKER,"Dejan","Rajic","6601996127","drajic@student.tgm.ac.at","Dejan123",new Address("DejanStreet",5,"Wien","Austria",1160));
        } catch (NoValidEmailException e) {
            throw new RuntimeException(e);
        } catch (NoValidPhoneNumberException e) {
            throw new RuntimeException(e);
        } catch (PasswordTooWeakException e) {
            throw new RuntimeException(e);
        }
        this.shirt1 = new Shirt("Dejan's slogan",ClothingSize.L);
        this.shirt2 = new Shirt("TGM's slogan",ClothingSize.M);
        this.shirt3 = new Shirt("Dritter slogan",ClothingSize.S);

        //Orders
        this.order1 = new Order(this.user2);
        order1.addItemToOrder(this.shirt1);
        order1.addItemToOrder(this.shirt2);

        this.order2 = new Order (user2);
        order2.addItemToOrder(this.shirt1);
        order2.addItemToOrder(this.shirt3);

        this.order3 = new Order (user2);
        order2.addItemToOrder(this.shirt1);
        order2.addItemToOrder(this.shirt3);
    }

    @DisplayName("Ein Benutzer wird korrekt angelegt")
    @Test
    void testen(){
        //Attribut des Konstruktors wird mit musterwert verglichen
        assertEquals("Musterstrasse",user.getUserAddress().getStreetName(),"Straßenname Falsch in address");
        //Das muss für alle attribute wiederholt werden um sie zu vergleichen

        //Überprüfung der A
        assertEquals(1,user.getUserAddress().getStreetNumber(),"Falsche Hausnummer in address");
        assertEquals("Wien",user.getUserAddress().getCity(),"Falsche Stadt in address");
        assertEquals("Austria",user.getUserAddress().getState(),"Falsches Land in address");
        assertEquals(1010,user.getUserAddress().getPostcode(),"Falsche Postleitzahl in address" );

        assertEquals("Max", user.getFirstName(),"Falscher Vorname in user");
        assertEquals("Muster",user.getLastName(),"Falscher Nachname in user");
        assertEquals("+4367712341234",user.getPhone(),"Falsche Telefonnummer in User");
        assertEquals("maxmuster@tgm.ac.at",user.getEmail(),"Falsche Email in User");


    }


    @DisplayName("Kein Benutzer wird angelegt, wenn die Tel.Nr nicht korrekt ist")
    @Test
    void test2(){
        assertThrows(NoValidPhoneNumberException.class,()-> new User(UserPrivilege.ADMIN,"Max","Muster","01234ABC123","maxmuster@tgm.ac.at","XA#*<TGM>b34y",this.user.getUserAddress()) ,"Test2: Telefonnummer nicht laut Validation");
    }

    @DisplayName("Kein Benutzer wird angelegt, wenn die eMail nicht passt")
    @Test
    void test3(){
        assertThrows(NoValidEmailException.class,()-> new User(UserPrivilege.ADMIN,"Max","Muster",this.user.getPhone(),"max@muster@tgm.ac.at","XA#*<TGM>b34y",this.user.getUserAddress()),"Test3: Email-Adresse falsch");
    }

    @DisplayName("Zwei Zahlungsmethoden angelegt, eine Korrekt, andere Falsch NVCCE erwartet")
    @Test
    void test4(){
        assertDoesNotThrow(()-> new PaymentMethod(5425233430109903L),"Test4: Falsche KreditkartenNr bei ((Nummer1))");
        assertThrows(NoValidCreditCardException.class,()-> new PaymentMethod(54252334903L),"Test4: Richtige KreditkartenNr bei falseTest((Nummer2))");

    }

    @DisplayName("Customer darf nichts für Admin erstellen -> OperationNotAllowedException")
    @Test
    void test5(){
        assertDoesNotThrow(()-> user.addPaymentOption(user2,5425233430109903L,"XA#*<TGM>b34y"));
        //Legt PaymentMethod mit KartenNr an
        assertDoesNotThrow(()-> user.addPaymentOption(user2,new PaymentMethod(5425233430109903L)),"Test5: Admin kann keine Falsche KartenNr zu Customer hinzufügen");
        //Customer legt für sich selbst an
        assertDoesNotThrow(()->user2.addPaymentOption(user2,new PaymentMethod(5425233430109903L)),"Test5: Customer kann nicht für sich selbst anlegen");
        //Customer legt für admin an
        assertThrows(OperationNotAllowedException.class,()->user2.addPaymentOption(user, new PaymentMethod(5425233430109903L)),"Test5: Customer darf nicht admin INfo bearbeiten");
    }

    @DisplayName("Eine Bestellung kann korrekt hinzugefügt werden")
    @Test
    void test6(){
        LogisticsSystem system = new LogisticsSystem();
        //Orders erstellen
        ArrayList orders = new ArrayList();
        orders.add(new Shirt("Dejan's slogan",ClothingSize.L));
        orders.add(new Shirt("TGM's slogan",ClothingSize.M));

        assertNotNull(orders);
        Order order1 = new Order(user2,OrderStatus.PROCESSING,orders);
        assertNotNull(order1);
        system.addOrder(order1);
        system.addOrder(order1);

    }
    @DisplayName("Eine Bestellung wird nur verschickt, wenn genug vorhanden ist")
    @Test
    void test7(){
        Store store = new Store(new Address("Street",11,"Wien","Austria",1160));

        store.addShirt(this.shirt1);
        store.addShirt(this.shirt2);

        LogisticsSystem system = new LogisticsSystem();
        system.registerNewUser(this.user2);
        system.registerNewStore(store);
        assertDoesNotThrow(()->system.processOrders(),"Störung bei den Orders im LogistikSystem");

        assertEquals(OrderStatus.DISPATCHED,order1.getCurrentStatus(),"Der Status der 1. Bestellung stimmt nicht überein");
        assertEquals(OrderStatus.CANCELLED,order2.getCurrentStatus(),"Der Status der 2. Bestellung stimmt nicht überein");

    }

    @DisplayName("Bestellungen sind nur von authorisierten NutzerInnen löschbar")
    @Test
    void test8(){
        LogisticsSystem system = new LogisticsSystem();
        system.addOrder(order1);
        system.addOrder(order2);

        assertDoesNotThrow(()->system.removeOrder(order2,this.user,"XA#*<TGM>b34y"),"beim removen wurde eine Exception geworfen");
        assertThrows(OperationNotAllowedException.class,()-> system.removeOrder(order1,user,"123FalsePW"),"Bei Falschen Admin PW, aktion trotzdem bewilligt");
        assertThrows(OperationNotAllowedException.class,()-> system.removeOrder(order3,user3,"123FalsePW"),"Bei Falscher Authorisation(Coworker),aktion trotzdem bewilligt");



    }





}
