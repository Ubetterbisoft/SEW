public class ErweitertesProdukt extends Produkt{
    private double rabatt;
    private Bewertung[] bewertung;
    
    public ErweitertesProdukt(long produktID, String bezeichnung, String beschreibung, int preis, double rabatt) throws NumericRangeException {
        if((produktID < 999999L)
        ||bezeichnung == null||beschreibung == null || preis < 0.0 || rabatt < 0 || rabatt >100){
            throw new NumericRangeException();
        }
        this.setPreis(preis);
        this.setBeschreibung(beschreibung);
        this.setBezeichnung(bezeichnung);
        this.setProduktID(produktID);
        this.setRabatt(rabatt);

    }
    public ErweitertesProdukt() throws NumericRangeException{
        this(1000000, "bezeichnung", "beschreibung", 1, 25);

    }
    
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
        for(int i = 0; i< this.bewertung.length; i++){
            bewertung2[i] = this.bewertung[i];
        }
     

        //Das neue Objekt wird in den erstmöglichen platz gegeben
        for(int i = 0; i < bewertung2.length; i++){
            if(bewertung2[i] == null){
                bewertung2[i] = bewertung;
                this.bewertung = bewertung2;
                return true;
            } 
        }
        return false;
    }
    

    
    public double durchschnittsbewertung(){
        if(bewertung == null)
            return 0.0;
        double rechnung = 0.0;
        int division = 0;
        
        for(int i = 0; i< this.bewertung.length;i++){
            if(this.bewertung[i] != null){
                rechnung = rechnung + this.bewertung[i].getBewertung();
                division++;
                continue;
            }
        }
        return rechnung / division;
    }
    
    
    @Override
    public String toString(){
        if(this.bewertung == null)
            return " / ";
        String bewertung = this.bewertung[0].toString();
        for(int i = 1; i <this.bewertung.length; i++){
            bewertung += "; " + this.bewertung[i].toString();
        }
        return super.toString() + "( " + ermaessigterPreis() + " Euro mit " + getRabatt() + "% Ermäsigung) -" + "Wertung: "+ durchschnittsbewertung() + " (" +bewertung +")";
    }

    public boolean equals(ErweitertesProdukt e){
        //Wenn der Rabatt gleich ist und die Bewertung auch dann wird true zurück gegeben
        if(this.rabatt == e.getRabatt() && (this.bewertung == null && e.getBewertung() == null))
            return true;
        /**
         * Überpüft alle möglichen zustände wo die objekte nicht gleich sein könnten und mindestens einer
         * der Bewertungs Arrays null sein könnte, Dass schließt den Fall einr Nullpointer Exception 
         * beim vergleich des Inhalts der Bewertungsarrays aus.
         * Zuerst wenn der rabatt gleich ist aber die Bewertungen nicht (2 Mal)
         * Danach wenn der Rabatt ungleich und genau das gleiche wie vorher und so weiter.......
         */
        if((this.rabatt == e.getRabatt() && (this.bewertung == null && e.getBewertung() != null))||
            this.rabatt == e.getRabatt() && (this.bewertung != null && e.getBewertung() == null) ||
            this.rabatt != e.getRabatt() && (this.bewertung == null && e.getBewertung() == null)||
            this.rabatt != e.getRabatt() && (this.bewertung == null && e.getBewertung() != null)||
            this.rabatt != e.getRabatt() && (this.bewertung != null && e.getBewertung() == null)){
                return false;
        }

        //Wenn rabatt gleich ist wird der inhalt des Arrays der nicht merh null sien kann übeprüft
        if(this.rabatt == e.getRabatt()){
            
            
            for(int i = 0; i < this.bewertung.length; i++){
                if(this.bewertung[i] != e.bewertung[i]){
                    return false;
                }
                
            }
            return true;
            
        }
        return true;
    }

    @Override
    public int hashCode(){
        int hashCode =  (int) this.rabatt;
        int hashCode2 =0;
        if(bewertung != null){
            hashCode2 = (int) this.bewertung.hashCode();
        }
        return hashCode + hashCode2 + super.hashCode();
    } 
    


    
}