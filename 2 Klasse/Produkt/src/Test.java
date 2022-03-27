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
        System.out.println(stift.produktDaten());
        System.out.println(stift.gesamtPreis(5));
        //System.out.println(stift2.produktDaten());

        System.out.println("Test zuhause-------------------------------\n");
        System.out.println(zuhauseTest.gesamtPreis(1));
        Bewertung zuHauseBewertung = new Bewertung(69,"Bestes produkt");

        /**
         * Stehengeblieben bei Bewertungsarray erstellen
         * Der fehler ist, dass das Bewertungsarray null ist, deswegen muss man es befüllen
         */
        Bewertung bewertung = new Bewertung(3.0,"Das Produkt ist mittelmäsig");
        
        System.out.println("\n" + zuhauseTest.neueBewertung(bewertung));
        System.out.println(zuhauseTest.getBewertung());
        System.out.println(zuhauseTest.bewertungenToString());
    }
}
