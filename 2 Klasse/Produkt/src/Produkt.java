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
        Beschreibung = beschreibung;
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
        this.produktID = 0;
        this.Beschreibung = " / ";
        this.Bezeichnung = " / ";
        this.preis = 0;
    }
    //Alle Attribute werden auf den parameterwert gesetzt
    public Produkt(long produktID, String Bezeichnung,String Beschreibung, double preis){
        this.produktID = produktID;
        this.Bezeichnung = Bezeichnung;
        this.Beschreibung = Beschreibung;
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
    public String produktDaten(){
        return this.produktID + " - " + this.Bezeichnung + ": " + this.Beschreibung +" - " + this.preis + " Euro";
    }
}