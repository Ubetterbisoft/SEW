/**
 * ist die TEstklasse
 * @author Dejan Rajic
 * @version 2021-11-10
 */
public class Test{
    /**
     * ist die TEstklasse
     * @author Dejan Rajic
     * @version 2021-11-10
     */
    public static void main(String[]args){
        Punkt2D ersterPunkt = new Punkt2D();
        Punkt2D zweiterPunkt = new Punkt2D(4,7);
        Dreieck dreieck1 = new Dreieck(3,5,6,6,7,8);
        Dreieck dreieck2 = new Dreieck(6,6,3,5,7,8);


        System.out.println("textDaten: "+ zweiterPunkt.textDaten());
        System.out.println("abstandNull: "+zweiterPunkt.abstandNull());
        System.out.println("equals: "+ ersterPunkt.equals(zweiterPunkt));
        System.out.println("abstandParam: " +Punkt2D.abstand(ersterPunkt,zweiterPunkt));
        System.out.println("abstandObj: " + ersterPunkt.abstand(zweiterPunkt));
        System.out.println("Umfang: "+ dreieck2.umfang());
        System.out.println("daten: "+ dreieck2.daten(6,6,3,5,7,8));
        System.out.println("Equals: "+ dreieck1.equals(dreieck2));
        System.out.println("istGroesser: "+ dreieck2.istGroesser(dreieck1));
    }
   
}