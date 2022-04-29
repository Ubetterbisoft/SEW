public class Test {
    public static void main(String[] args) {
        //long produktID, String Bezeichnung,String Beschreibung, double preis
        try{
            Produkt stift = new Produkt(2345333342L, "Ein Blauer Stift" , "Dieser Stift ist serh robust und qualitativ hochwertig" , 3);
            System.out.println(stift.getBeschreibung());
            ErweitertesProdukt erweiterterStift = new ErweitertesProdukt();
            Bewertung b = new Bewertung(3.3,"grandios");
            erweiterterStift.neueBewertung(b);
            System.out.println(erweiterterStift.toString());
        }catch(NumericRangeException e){
            System.out.println(e +"\n");
            e.printStackTrace();
        }
        




    }   
}
