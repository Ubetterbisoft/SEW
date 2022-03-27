public class Kegel {
    //Attribute
    private double durchmesser;
    private double hoehe;
    private double volumen;
    private double radius;
    private double oberflaeche;

    //Konstruktor
    Kegel(double durchmesser,double hoehe){
        this.durchmesser = durchmesser;
        this.hoehe = hoehe;
        
        
    }
    //Default Konstruktor
    Kegel(){
        
    }

    //Getter und Setter methoden
    void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setOberflaeche(double oberflaeche) {
        this.oberflaeche = oberflaeche;
    }
    public double getOberflaeche() {
        return oberflaeche;
    }
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    public double getVolumen() {
        return volumen;
    }

    void setDurchmesser(double durchmesser){
        this.durchmesser = durchmesser;
    }
    double getDurchmesser(){
        return  this.durchmesser;
    }
    void setHoehe(double hoehe){
        this.hoehe = hoehe;
    }
    double getHoehe(){
        return  this.hoehe;
    }

    //Berechnet alle Werte
  
    public double[] berechnung(double hoehe, double durchmesser){
        double radius = durchmesser /2;
        double mantellinie = Math.sqrt(Math.pow(hoehe,2)+Math.pow(radius,2));
        double oberflaeche = radius * Math.PI * (radius + mantellinie);
        double volumen = Math.pow(radius,2.0) * Math.PI * this.hoehe / 3;
        double[] array={radius,oberflaeche,volumen};
        return array;
        
    }

    //Gibt die Informationen zu den Attributen aus
    String textInfo(){
        String TextInfo =("Durchmesser: "+ getDurchmesser()+", Hoehe: " + getHoehe());
        return TextInfo;
    }
    //gibt alle Informationen aus
    String gesamtInfo(){
        String GesamtInfo =(textInfo()+", Oberflaeche: "+ getOberflaeche()+", Radius: "+ getRadius()+", Volumen: "+getVolumen());
        return GesamtInfo;
    }
    //VergrößerungsMethoden die die Attribute verändern können
    /* Problem bei den Vergröserungsmethoden ist das man sie überladen soll
     * jedoch muss man ebenfalls die Parameter (datentyp) beibehalten um die berechnung 
     * ohne datenverlust durchführen zu können
     * Ich werde hier einfach leere parameter einfügen die keine Funktion erfüllen
     */
    void vergroessern(double hoeheDazu){
        this.hoehe = this.hoehe + hoeheDazu;
    }
    void vergroessern(double durchmesserDazu, char leer){
        this.durchmesser = this.durchmesser + durchmesserDazu;
    }
    void vergroessern(double durchmesser, double hoehe){
        this.hoehe = hoehe;
        this.durchmesser = durchmesser;
    }

    
}
