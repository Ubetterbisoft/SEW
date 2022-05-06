
public class Test {
    public static void main(String[] args) {
        //long produktID, String Bezeichnung,String Beschreibung, double preis
        Produkt stift = new Produkt(23453333423324L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
        stift.setPreis(43);
        ErweitertesProdukt stift2 = new ErweitertesProdukt( 24123532L, "Ein Schwarzer Stift ", "dieser Stift ist sehr robust und qualitativ hovhwertig," ,5, 50);
        //Bewertung bewertung = new Bewertung(10, "text");
        //Bewertung bewertungOBJ = new Bewertung(20, "Text2");
        stift2.setRabatt(4);



        ErweitertesProdukt zuhauseTest = new ErweitertesProdukt(2345L,"/","/",20,0);
        zuhauseTest.setRabatt(25);
        System.out.println(stift.toString());
        System.out.println(stift.gesamtPreis(5));
        //System.out.println(stift2.produktDaten());

        System.out.println("Test zuhause-------------------------------\n");
        System.out.println(zuhauseTest.gesamtPreis(1));
        Bewertung zuHauseBewertung = new Bewertung(69,"Bestes produkt");
        zuhauseTest.neueBewertung(zuHauseBewertung);
        /**
         * Stehengeblieben bei Bewertungsarray erstellen
         * Der fehler ist, dass das Bewertungsarray null ist, deswegen muss man es befüllen
         */
        Bewertung bewertung = new Bewertung(3.0,"Das Produkt ist mittelmäsig");
        Bewertung bewertung2 = new Bewertung(10.0,"Das Produkt ist Grandios");

        zuhauseTest.neueBewertung(bewertung2);
        System.out.println("\n" + zuhauseTest.neueBewertung(bewertung));
        
     

        System.out.println("Schule test ----------------------------------------\n");
        
        System.out.println(zuhauseTest.durchschnittsbewertung()+"\n");
        System.out.println(zuhauseTest.toString()+"\n");

        //printen von stift2
        stift2.neueBewertung(bewertung);
        stift2.neueBewertung(bewertung2);
        System.out.println(stift2.toString());

        System.out.println("Testen Der Klasse (Schritt 3)------------------------------------\n");

        Produkt p1 = new Produkt(9876543210L, "Mappe rot", "eine dünne rote Mappe", 2.49);
        System.out.println("Produkt: " + p1);
        Produkt p2 = new Produkt(9876543210L, "Mappe rot", "eine dünne rote Mappe", 2.49);
        System.out.println("Vergleich: " + p1.equals(p2));
        //man soll zwei gleiche objekte erstellen, sie ausgeben undvergleichen
        //Es werden zwei Objekte mit den gleichen Attributen erstellt, es werden die
        //Referenzen vergleichen und Ausgegeben, nicht der Inhalt
        System.out.println();

        //testen von Erweitertes Produkt
        ErweitertesProdukt stift3 = new ErweitertesProdukt(24123532L, "Ein Schwarzer Stift ", "dieser Stift ist sehr robust und qualitativ hovhwertig," ,5, 50);
        ErweitertesProdukt stift4 = new ErweitertesProdukt(24123532L, "Ein Schwarzer Stift ", "dieser Stift ist sehr robust und qualitativ hovhwertig," ,5, 50);
        
        System.out.println("stift3: "+ stift3);
        System.out.println("Vergleich: "+ stift3.equals(p2));

        //testen von Bewertung

        System.out.println();

        Bewertung bewertungTest = new Bewertung(3.0,"Das Produkt ist mittelmäsig");
        Bewertung bewertungTest2 = new Bewertung(3.0,"Das Produkt ist mittelmäsig");

        Bewertung bewertungTest3 = new Bewertung(4.0,"Das Produkt ist mittelmäsig");

        System.out.println("Bewertung: "+ bewertungTest);
        System.out.println("Vergleich: "+ bewertungTest.equals(bewertungTest2));

        /**
         * Stehengeblieben bei Schritt 3 Methoden der Klasse Object überschreiben bzw. überladen
         */
        System.out.println(stift.toString());
        System.out.println("Equanls vergleich False: " + bewertungTest.equals(bewertungTest3) );
        System.out.println("Equanls vergleich true: " + bewertungTest.equals(bewertungTest) +"\n" );
        
        Produkt obj = new Produkt();
        Produkt obj2 = new Produkt(324523L, "Bezeichnung", "Beschreibung", 23);
        System.out.println(" Produkt Equals False: "+obj.equals(obj2));
        System.out.println(" Produkt Equals False: "+obj.equals(obj));

        ErweitertesProdukt e = new ErweitertesProdukt();
        ErweitertesProdukt e1 = new ErweitertesProdukt(2342L, "Dejan", "beschreibung", 45, 45);
    
        ErweitertesProdukt e2 = new ErweitertesProdukt(2342L, "Dejan", "beschreibung", 45, 45);
        
        System.out.println("Erweitertest produkt vergleich False: " + e.equals(e1));
        
        System.out.println("Erweitertes produkt vergleich true: "+ e1.equals(e2));
        //Es werden alle hashcodes von allen erstellten objekten ausgegeben. Alle attribute werden miteinander addiert und ausgegeben

        System.out.println("Hashcodes --------------------------------------------------------");
        System.out.println("Klasse: Produkt, Name: Stift: " + stift.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: Stift2: " + stift2.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: zuhauseTest: " + zuhauseTest.hashCode());
        System.out.println("Klasse: Bewertung, Name: zuhauseBewertung: " + zuHauseBewertung.hashCode());
        System.out.println("Klasse: Bewertung, Name: bewertung: " + bewertung.hashCode());
        System.out.println("Klasse: Bewertung, Name: bewertung2: " + bewertung2.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: Stift3: " + stift3.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: Stift4: " + stift4.hashCode());
        System.out.println("Klasse: Bewertung, Name: bewertungTest " + bewertungTest.hashCode());
        System.out.println("Klasse: Bewertung, Name: bewertungTest2: " + bewertungTest2.hashCode());
        System.out.println("Klasse: Bewertung, Name: bewertungTest3: " + bewertungTest3.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: e: " + e.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: e1: " + e1.hashCode());
        System.out.println("Klasse: ErweitertesProdukt, Name: e2: " + e2.hashCode());

        System.out.println("Test Records-------------------------------------------------");

        //Testung vom cannonical constructor und toString methode
        BewertungRecord record = new BewertungRecord(4.5,"Gut");
        System.out.println(record.toString());

        //Testung von only bewertung parameter
        BewertungRecord record2 = new BewertungRecord(10);
        System.out.println(record2.toString());

        //Testung von der intWertung methode
        System.out.println(record.intWertung());

        //Testung von ausgabe der attribute seperat
        System.out.println(record.bewertung() + "\n" + record.Text() );

        //testung von negativen bewertung parameter
        /** 
        BewertungRecord record3 = new BewertungRecord(-5,"Gut");
        System.out.println(record3.toString());
        */

        
        
    }   
}