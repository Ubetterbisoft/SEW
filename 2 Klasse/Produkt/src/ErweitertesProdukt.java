public class ErweitertesProdukt extends Produkt{
    private double rabatt;
    private Bewertung[] bewertung;
    
    public ErweitertesProdukt(long produktID, String bezeichnung, String beschreibung, int preis, double rabatt) {
        this.setPreis(preis);
        this.setBeschreibung(beschreibung);
        this.setBezeichnung(bezeichnung);
        this.setProduktID(produktID);
        this.setRabatt(rabatt);

    }
    public ErweitertesProdukt(){
        this.setPreis(0.0);
        this.setBeschreibung(" / ;");
        this.setBezeichnung(" / ;");
        this.setProduktID(0);
        this.setRabatt(0);

    }
    //Bewertung Konstruktor ist falsche
    /** 
    public void setBewertung(Bewertung bewertung) {
        for(int i = 0; i < this.bewertung.length; i++){
            this.bewertung[i] = bewertung;
        }
    }
    */
    public void setRabatt(double rabatt) {
        if(rabatt <= 100 && rabatt >= 0){
            this.rabatt = rabatt;
        }    
            
    }
    public void setBewertung(Bewertung bewertung) {
        for(int i = 0; i < this.bewertung.length; i++){
            if(this.bewertung[i] == null){
                this.bewertung[i] = bewertung;
                
            } 
        }
    }
    public Bewertung[] getBewertung() {
        return bewertung;
    }
    public double getRabatt() {
        return rabatt;
    }

    public double ermaessigterPreis(){
        //ermäsigter Preis von einem einzelnen Produkt
        //Preis - Anteil (Anteil = G*P / 100)
        double minus = (super.getPreis() * rabatt / 100);
        return super.getPreis() - minus; 
    }

    public double gesamtPreis(int anzahl){
        //ermässigter Preis von allen Produkten zusammen
        double gesamtPreis = super.gesamtPreis(anzahl);
        double minus = gesamtPreis * rabatt / 100;
        return gesamtPreis - minus;

    }

    public boolean neueBewertung(Bewertung bewertung){
        if(this.bewertung == null){
            this.bewertung = new Bewertung[1];
            this.bewertung[0] = bewertung;
            return true;
        }
        //Wenn es ein Platz im Array gibt muss man nicht erweitern
        for(int i = 0; i < this.bewertung.length; i++){
            if(this.bewertung[i] == null){
                this.bewertung[i] = bewertung;
                return true;
            } 
        }

        //Es gibt kein Platz im Array also wird erweitert
        int erweiterung = this.bewertung.length +1;
        Bewertung[] bewertung2 = new Bewertung[erweiterung];
        bewertung2 = this.bewertung;

        //Das neue Objekt wird in den erstmöglichen platz gegeben
        for(int i = 0; i < bewertung2.length; i++){
            if(bewertung2[i] == null){
                bewertung2[i] = bewertung;
                return true;
            } 
        }
        return false;
    }
    public String bewertungenToString(){
        if(this.bewertung == null)
            return "Keine bewertung vorhanden";
        String Ausgabe = "";
        for(int i = 0; i < this.bewertung.length; i++){
            if(this.bewertung[i] != null){
                Ausgabe +=  " "+ this.bewertung[i] +" ";
            }else{
                Ausgabe += " / ";
            }

        }
        return Ausgabe;
    }

    /** 
    public double durchschnittsbewertung(){
        double rechnung = 0.0;
        int division = 0;
        
        for(int i = 0; i< this.bewertung.length;i++){
            if(this.bewertung[i] != null){
                rechnung = rechnung + this.bewertung[i].getBewertung();
                division++;
            }
        }
        return rechnung / division;
    }
    */
    //nicht fertig
    /** 
    public String produktDaten(){
        Bewertung bewertung = new Bewertung();
        return super.produktDaten() + "( " + ermaessigterPreis() + " Euro mit " + getRabatt() + "% Ermäsigung) -" + "Wertung: "+ durchschnittsbewertung() + " (" + bewertung +"),";
    }
    */


    
}