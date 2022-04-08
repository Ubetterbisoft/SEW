/**
 * Die Klasse ist ein Object und enthält attribute und object methoden
 */
public class Produkt{

    private long produktID;
    private String Bezeichnung;
    private String Beschreibung;
    private double preis;

    public double getPreis() {
        return preis;
    }
    public void setPreis(double preis) {
        this.preis = preis;
    }
    public void setBeschreibung(String beschreibung) {
        if(beschreibung!=null)
            Beschreibung = beschreibung;
        else
            Beschreibung=" / ";
    }
    public String getBeschreibung() {
        return Beschreibung;
    }
    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }
    public String getBezeichnung() {
        return Bezeichnung;
    }
    public void setProduktID(long produktID) {
        this.produktID = produktID;
    }
    public long getProduktID() {
        return produktID;
    }
    //Alle Atribute werden auf 0 gesetzt
    public Produkt(){
        this(0," / ",null,0);

    }
    //Alle Attribute werden auf den parameterwert gesetzt
    public Produkt(long produktID, String Bezeichnung,String Beschreibung, double preis){
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
    public double gesamtPreis(int stuekZahl){
        double anzahlConverted = (double) stuekZahl; 
        return this.preis * anzahlConverted;
        
    }
    /**
     * Gibt die Produktdaten im verlangen Format aus
     */
    @Override
    public String toString(){
        return this.produktID + " - " + this.Bezeichnung + ": " + this.Beschreibung +" - " + this.preis + " Euro";
    }
    public boolean equals(Produkt p){
        if(this.produktID == p.getProduktID() && this.Bezeichnung.equals(p.getBezeichnung()) && this.Beschreibung.equals(p.getBeschreibung()) && this.preis == p.getPreis() ){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int bezeichnung = this.Bezeichnung.hashCode();
        int beschreibung = this.Beschreibung.hashCode();
        int preis = (int) Math.round(this.preis);
        int produktId = (int) this.produktID;

        return bezeichnung + beschreibung + preis + produktId;
    }
}