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
    @Override
    public boolean equals(Object p){
        //Es wird geschaut ob p einen inhalt zum vergleichen hat
        if(p == null) {
		    return false;
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
		
        ErweitertesProdukt p1 = (ErweitertesProdukt) p;
		//Alle attribute werden miteinander verglichen
		return (super.getBeschreibung() == p1.getBeschreibung()) && (super.getBezeichnung() == p1.getBezeichnung()) && (super.getPreis() == p1.getPreis()) && (super.getProduktID() == p1.getProduktID()) && (this.rabatt == p1.rabatt);
	}
    @Override
    public int hashCode(){
        //Das rabbat attribut werd als in umgewandelt
        int hashCode =  (int) this.rabatt;
        //Wird für den fall 0 gesetzt wenn bewertung null ist
        int hashCode2 =0;
        if(bewertung != null){
            //Der Hashcode von bewertung wird der variable zugewiesen
            hashCode2 = (int) this.bewertung.hashCode();
        }
        //alle hashwerte werden miteinander addiert und die haswerte von der geerbten methode werden aufgerufen
        return hashCode + hashCode2 + super.hashCode();
    } 
    


    
}