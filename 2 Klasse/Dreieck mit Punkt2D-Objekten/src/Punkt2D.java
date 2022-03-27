/**
 * Erstellt zweidimensionale Punkte und berechnet die distanz zwischen diesen
 * @author Dejan Rajic
 * @version 2021-11-10
 */
public class Punkt2D{
    //Attribute
    private int x;
    private int y;

    //Konstruktoren
    Punkt2D(){
        this.x = 0;
        this.y = 0;
    }

    Punkt2D(int x,int y){
        this.x = x;
        this.y = y;
    }

    //Setter Getter Methoden
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return this.x;
    }

    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return this.y;
    }
    /**
     * Gibt die Koordinaten eines Punktes aus
     * @author Dejan Rajic
     * @version 2021-11-10
     * @return den String
     */
    public String textDaten(){
        String TextDaten ="("+this.x +"/"+ this.y+ ")";
        return TextDaten;
    }
    /**
     * Gibt den Obstand zum Nullpunkt an
     * @author Dejan Rajic
     * @version 2021-11-10
     * @return den die Distanz zum Nullpunkt
     */
    public double abstandNull(){
        //Satz des pythagoras
        double distanzZuNullpunkt = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
        return distanzZuNullpunkt;
    }
    /**
     * Gibt den Obstand zum Nullpunkt an
     * @author Dejan Rajic
     * @version 2021-11-10
     * @param x ist x
     * @param y ist y
     * @return den die Distanz zum Nullpunkt
     */
    public double abstandNull(int x, int y){
        //Satz des pythagoras
        double distanzZuNullpunkt =  Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return distanzZuNullpunkt;
    }
    /**
     * Vergleicht ob zwei punkte gleich sind
     * @author Dejan Rajic
     * @version 2021-11-10
     * @param zweites ist der andere Punkt
     * @return wahr oder falsch
     */
    public boolean equals(Punkt2D zweites) {
        if((zweites.x == this.x)&&(zweites.y == this.y)){
            return true;
        }
        return false;
    }
    /**
     * Berechnet den Abstand von einem Punkt zum anderen Punkt
     * @author Dejan Rajic
     * @version 2021-11-10
     * @param punkt ist der Punkt
     * @param punkt1 ist der zweite punkt
     * @return die distanz zwischen den Punkten
     */
    public static double abstand(Punkt2D punkt, Punkt2D punkt1){
        return Math.sqrt(Math.pow((punkt.getX() - punkt1.x), 2) + Math.pow((punkt.getY()-punkt1.y), 2));
    }
    /**
     * Berechnet den Abstand von einem Punkt zum anderen Punkt
     * @author Dejan Rajic
     * @version 2021-11-10
     * @param punkt ist der punkt
     * @return die distanz zwischen den Punkten
     */
    public double abstand(Punkt2D punkt){
        return Math.sqrt(Math.pow((punkt.getX() - this.x), 2) + Math.pow((punkt.getY()-this.y), 2));
    }
    

    

}