
/**
 * Die Klasse ist ein Object und enthält attribute und object methoden
 */
public class Produkt implements Identifizierbar, Kaufbar{

    private long produktID;
    private String Bezeichnung;
    private String Beschreibung;
    private double preis;
    
    @Override
    public double getPreis() {
        return preis;
    }
    public void setPreis(double preis) throws NumericRangeException{
        if(preis >= 0.0){
            this.preis = preis;
        }else{
            throw new NumericRangeException("Ein Preis kann nicht negativ sein");
        }
    }
    public void setBeschreibung(String beschreibung) throws IllegalArgumentException {
        if(beschreibung!=null){
            this.Beschreibung = beschreibung;
        }else{
            throw new IllegalArgumentException("Die Beschreibung darf nicht null sein");
        }
            
    }
    public String getBeschreibung() {
        return Beschreibung;
    }
    public void setBezeichnung(String bezeichnung) throws IllegalArgumentException {
        if(bezeichnung!=null && bezeichnung.length() > 1 && bezeichnung != "  "){
            this.Beschreibung = bezeichnung;
        }else{
            throw new IllegalArgumentException("Die Beschreibung muss mindestens zwei valide Zeichen beinhalten");
        }
    }
    public String getBezeichnung() {
        return Bezeichnung;
    }
    
    public void setProduktID(long produktID) throws NumericRangeException {
        if(produktID < 1000000L){
            throw new NumericRangeException("Die ProduktID muss mindestens 7 Stellen aufseisen");
            
        }else{
            this.produktID = produktID;
        }
    }
    
    public long getProduktID() {
        return produktID;
    }
    //Alle Atribute werden auf 0 gesetzt
    public Produkt() throws NumericRangeException{
        this(1000000L," / "," / ",1);

    }
    //Alle Attribute werden auf den parameterwert gesetzt
    public Produkt(long produktID, String Bezeichnung,String Beschreibung, double preis) throws NumericRangeException{
        if((produktID < 1000000L)
        ||Bezeichnung == null||Beschreibung == null || preis < 0.0){
            throw new NumericRangeException();
        }
        this.produktID = produktID;
        this.Bezeichnung = Bezeichnung;
        this.setBeschreibung(Beschreibung);
        this.preis = preis;
    }
    /**
     * Der Gesammtpreis wird ausgegeben indem man den Preis des produktes
     * mit der Stückanzahl multipliziert
     * @param stuekZahl ist die Stückanzahl
     */
    @Override
    public double gesamtPreis(int stuekZahl) throws NumericRangeException{
        if(stuekZahl >= 0){
            double anzahlConverted = (double) stuekZahl; 
            return this.preis * anzahlConverted;
        }else{
            throw new NumericRangeException("Die Stückanzahl muss >= 0 sein");
        }
    }
    /**
     * Gibt die Produktdaten im verlangen Format aus
     */
    @Override
    public String toString(){
        return this.produktID + " - " + this.Bezeichnung + ": " + this.Beschreibung +" - " + this.preis + " Euro";
    }
    public boolean equals(Produkt p) throws IllegalArgumentException{
        if(p != null){
            if(this.produktID == p.getProduktID() && this.Bezeichnung.equals(p.getBezeichnung()) && this.Beschreibung.equals(p.getBeschreibung()) && this.preis == p.getPreis() ){
                return true;
            }
            return false;
        }else{
            throw new IllegalArgumentException("Das Produkt objekt darf nich null sein")
;        }
    }
    @Override
    public int hashCode(){
        int bezeichnung = this.Bezeichnung.hashCode();
        int beschreibung = this.Beschreibung.hashCode();
        int preis = (int) Math.round(this.preis);
        int produktId = (int) this.produktID;

        return bezeichnung + beschreibung + preis + produktId;
    }
    @Override
    public String identifier(){
        String Id = this.produktID + "";
        for(int i = Id.length(); i < 15;i++){
            Id = "0" + Id;
        }
        return Id;
        
    
    }
}