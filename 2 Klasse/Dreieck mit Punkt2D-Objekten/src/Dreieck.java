/**
 * Erstellt Dreiecke und stellt berechnungen für sie zur verfügung
 * @author Dejan Rajic
 * @version 2021-11-10
 */

public class Dreieck{
    Punkt2D ersterPunkt = new Punkt2D();
    Punkt2D zweiterPunkt = new Punkt2D();
    Punkt2D dritterPunkt = new Punkt2D();
    
    

    public Dreieck(){
        setErster(0,0);
        setZweiter(0,0);
        setDritter(0,0);
    }

    public Dreieck(int x1, int y1, int x2, int y2, int x3, int y3){
        setErster(x1,y1);
        setZweiter(x2, y2);
        setDritter(x3, y3);
    }

    public void setErster(int x1, int y1){
        ersterPunkt.setX(x1);
        ersterPunkt.setY(y1);
    }

    public void setZweiter(int x2, int y2){
        zweiterPunkt.setX(x2);
        zweiterPunkt.setY(y2);
    }

    public void setDritter(int x3, int y3){
        dritterPunkt.setX(x3);
        ersterPunkt.setY(y3);
    }


    public Punkt2D getErster(){
        return ersterPunkt;
    }

    public Punkt2D getZweiter(){
        return zweiterPunkt;
    }

    public Punkt2D getDritter(){
        return dritterPunkt;
    }
    /**
     * Gibt die koordinaten der punkte wieder und dem umfang des Dreiecks
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @param x3 x3
     * @param y3 y3
     * @return die daten
     */
    public String daten(int x1, int y1, int x2, int y2, int x3, int y3){
        String ausgabe = "Der erste Punkt vom Dreieck : (" +x1 +"/"+ y1 +")\n" +
                        "Der zweite  Punkt vom Dreieck : (" +x2 +"/"+ y2 +")\n"  +
                        "Der dritte Punkt vom Dreieck : (" +x3 +"/"+ y3 +")";
        return ausgabe;
    }
    /**
     * Berechnet den Umfang
     * @return den Umfang
     */
    public double umfang(){
        double a = ersterPunkt.abstand(zweiterPunkt);
        double b = zweiterPunkt.abstand(dritterPunkt);
        double c =  dritterPunkt.abstand(ersterPunkt);


        return a+b+c;

    }
    /**
     * Überprüft ob die Punkte beider dreiecke exakt übereinstimmen
     * @param dreieck2 zweites Dreieck
     * @return
     */
    public boolean equalsExact(Dreieck dreieck2){
        if((this.ersterPunkt.equals(dreieck2.ersterPunkt))&&(this.zweiterPunkt.equals(dreieck2.zweiterPunkt))&&(this.dritterPunkt.equals(dreieck2.dritterPunkt))){
            return true;
        }
        return false;
    }
    /**
     * Überprüft ob die werte beider dreiecke übereinstimmen
     * @param dreieck2 zweites Dreieck
     * @return das ergebnis
     */
    public boolean equals(Dreieck dreieck2){
        
        if((this.equalsExact(dreieck2))||(this.ersterPunkt.equals(dreieck2.zweiterPunkt))||this.ersterPunkt.equals(dreieck2.dritterPunkt)
        ||dreieck2.ersterPunkt.equals(this.zweiterPunkt)|| dreieck2.ersterPunkt.equals(this.dritterPunkt)){
            return true;
        }
        return false;
    }
    /**
     * Ob das dreieck größer ist
     * @param dreieck2 zweites Dreieck
     * @return das ergebnis
     */
    public boolean istGroesser(Dreieck dreieck2){
        if(this.umfang() > dreieck2.umfang()){
            return true;
        }
        return false;
    }



}