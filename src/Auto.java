public class Auto {
    private String Geschwindigkeit;
    private double laenge;
    private double hoehe;
    private int gewicht;

    public Auto(String Geschwindigkeit, double laenge, double hoehe, int gewicht){
        this.Geschwindigkeit = Geschwindigkeit;
        this.laenge = laenge;
        this.hoehe = hoehe;
        this.gewicht = gewicht;
    }

    public Auto(){
        this("180 Km/h",5.7,3.0,1500);
    }

    @Override
    public String toString(){
        return this.Geschwindigkeit +" ,"+ this.laenge +" ,"+ this.hoehe +" ," + this.gewicht;
    }
    public String flex(){
        return this.toString() +" Schwach";
    }
}
