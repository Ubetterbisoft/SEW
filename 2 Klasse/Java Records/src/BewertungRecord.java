public record BewertungRecord(double bewertung,String Text) {
    
    /**
     * Mann muss keine Parameter angeben, weil sie vom denen in Zeile 1 übernommen werden
     * Die Attribute muss man nicht zuweisen, dass wird automatisch erstellt
     */
    public BewertungRecord{
        if(bewertung < 0){
            throw new IllegalArgumentException("Wertung darf nicht kleiner als 0 sein");
        }
    }
    /**
     * Konstruktor der nur eine Bewertung übergibt
     * @param bewertung
     */
    public BewertungRecord(double bewertung){
        //Der cannonical constructor (1. Zeile) wird mit den richtigen werten aufgerufen
        this(bewertung,"");
    }
    @Override
    public String toString(){
        return "Bewertung: " + this.bewertung + " Text: " + this.Text;
    }

    public int intWertung(){
        return (int) Math.round(bewertung);
    }
}
