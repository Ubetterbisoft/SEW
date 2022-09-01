public class ErweitertesProdukt extends Produkt{
    private double rabatt;
    private Bewertung[] bewertung;
    
    public ErweitertesProdukt(long produktID, String bezeichnung, String beschreibung, int preis, double rabatt) throws NumericRangeException {
        if(((produktID < 1000000L)
        ||bezeichnung == null|| beschreibung == null || preis < 0.0 ||  rabatt < 0 || rabatt >100)){
            throw new NumericRangeException();
        }

        this.setPreis(preis);
        this.setBeschreibung(beschreibung);
        this.setBezeichnung(bezeichnung);
        this.setProduktID(produktID);
        this.setRabatt(rabatt);

    }
    public ErweitertesProdukt() throws NumericRangeException{
        this(1000000L, "bezeichnung", "beschreibung", 1, 25);

    }
    
    public void setRabatt(double rabatt) throws NumericRangeException {
        if(rabatt <= 100 && rabatt >= 0){
            this.rabatt = rabatt;
        }else{
            throw new NumericRangeException("Der Rabattwert mus zwischen 0 - 100 sein");
        }
            
    }
    public void setBewertung(Bewertung bewertung1)  throws IllegalArgumentException, NumericRangeException{
        if(bewertung1 == null){
            throw new IllegalArgumentException("Das Bewertungsobjekt darf nich null sein");
        }
        if(bewertung == null){
            throw new NumericRangeException("Der Bewertungsarray ");
        }
            for(int i = 0; i < this.bewertung.length; i++){
                if(this.bewertung[i] == null){
                    this.bewertung[i] = bewertung1;
                
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

    public double gesamtPreis(int anzahl) throws NumericRangeException{
        //ermässigter Preis von allen Produkten zusammen
            double gesamtPreis = super.gesamtPreis(anzahl);
            double minus = gesamtPreis * rabatt / 100;
            return gesamtPreis - minus;

    }

    public boolean neueBewertung(Bewertung bewertung) throws IllegalArgumentException{
        if(bewertung == null){
            throw new IllegalArgumentException("Das Bewertungsobjekt kann nicht null sein");
        }
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

    public boolean equals(ErweitertesProdukt p)throws IllegalArgumentException{
        if(p == null) {
		    throw new IllegalArgumentException("Das erweiterte Produkt soll nicht null sein");
		}
        /*
		 * 1.Schritt wir schauen ob die Referenz gleich ist
		 * Falls ja ist es exact dasselbe Produkt
		 */
		if(this == p) {
			return true;
		}
		
		
		
		/*
		 * 2.Schritt	 wir vergleichen ob die Klassen gleich sind
		 * Falls die Klassen nicht gleich sind kann man direkt false zurückgeben
		 * dies hat den Grund, weil die Atribute dann anders sind und nicht verglichen werden können
		 */
		if(getClass() != p.getClass()) {
			return false;
		}
		
		
		return (super.getBeschreibung() == p.getBeschreibung()) && (super.getBezeichnung() == p.getBezeichnung()) && (super.getPreis() == p.getPreis()) && (super.getProduktID() == p.getProduktID()) && (this.rabatt == p.rabatt);
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