public class Test {
    public static void main(String[] args) {
        //long produktID, String Bezeichnung,String Beschreibung, double preis
        
        try{
            Produkt stift = new Produkt(10000000L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
            System.out.println(stift.getBeschreibung());
            ErweitertesProdukt erweiterterStift = new ErweitertesProdukt();
            Bewertung b = new Bewertung(3.3,"grandios");
            erweiterterStift.neueBewertung(b);
            System.out.println(erweiterterStift.toString());

            
        }catch(NumericRangeException e){
            e.printStackTrace();
        }

        // Es wird die setPreis Methode aus Produkt getestet
        try{
            Produkt stift = new Produkt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
            stift.setPreis(4);
        }catch(NumericRangeException e){
            e.printStackTrace();
        }

        //Es wird die setBeschreibung methode aus Produkt getestet
        try{
            Produkt stift = new Produkt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
            stift.setBeschreibung("Dej");
            System.out.println("\n" + stift.toString());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }catch(NumericRangeException e){
            e.printStackTrace();
        }
        //Es wird die setBezeichnung methode aus Produkt getestet
        try{
            Produkt stift = new Produkt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
            stift.setBezeichnung("De");
            System.out.println("\n" + stift.toString());
        }catch(NumericRangeException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        //Es wird die setProduktID methode getestet
        try{
            Produkt stift = new Produkt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
            stift.setProduktID(222342342344L);
            System.out.println("\n" + stift.toString());
        }catch(NumericRangeException e){
            e.printStackTrace();
        }

        //Es wird die setRabatt methode aus Erweitertes Produkt getestet
        try{
            ErweitertesProdukt stift2 = new ErweitertesProdukt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3, 25);
            stift2.setRabatt(100);
        }catch(NumericRangeException e){
            e.printStackTrace();
        }
        
        //Es wird die neueBewertung methode aus ERweitertes Produkt getestet
        
        try{
            ErweitertesProdukt stift2 = new ErweitertesProdukt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3, 25);
            Bewertung b = new Bewertung(3.3,"grandios");
            stift2.neueBewertung(b);
            
            
        }catch(NumericRangeException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        //Equalsmethode aus Erweitertessprodukt
        try{
            ErweitertesProdukt stift2 = new ErweitertesProdukt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3, 25);
            ErweitertesProdukt stift3 = new ErweitertesProdukt();
            ErweitertesProdukt stift4 = new ErweitertesProdukt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3, 25);
            System.out.println(stift2.equals(stift4));
            
            
        }catch(NumericRangeException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------");
        //Methode identifizierbar
        try{
            Produkt p = new Produkt(333323223L, "Bezeichnung", "Beschreibung", 55);
            System.out.println(p.identifier());
        }catch(NumericRangeException e){
            e.printStackTrace();
        }

        //Methode gesamtpreis
        try{

            Produkt p = new Produkt(333323223L, "Bezeichnung", "Beschreibung", 55);
            System.out.println(p.gesamtPreis(4));

        }catch(NumericRangeException e){
            e.printStackTrace();
        }
        //Methode getPreis
        try{

            Produkt p = new Produkt(333323223L, "Bezeichnung", "Beschreibung", 25);
            System.out.println(p.getPreis());

        }catch(NumericRangeException e){
            e.printStackTrace();
        }




    }   
}
