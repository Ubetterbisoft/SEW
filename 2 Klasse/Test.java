import java.util.*;
public class Test{
    public static void main(String[] args) {
        Scanner Eingabe;
        double hoehe;
        double durchmesser;
        do{
            //Die Eingabe wird aufgefordert und eingelesen
            Eingabe = new Scanner(System.in);
            System.out.println("Geben Sie die Hoehe ein");
            hoehe = Eingabe.nextDouble();
            System.out.println("Geben Sie den Durchmesser ein");
            durchmesser = Eingabe.nextDouble();
            if((hoehe <=0.0)&&(durchmesser <=0.0)){
                System.out.println("Die von Ihnen eingegebenen Werte sind nicht Sinnvol und müssen gröser als 0.0 sein");
            }
            
        }while((hoehe <=0.0)&&(durchmesser <=0.0));
        Eingabe.close();
        //Das KegelObjekt wird erstellt und der auffang array wird von der berechnungs objektmethode initialisiert
        Kegel kegelObj = new Kegel(durchmesser,hoehe);
        double[] auffangArray = kegelObj.berechnung(hoehe, durchmesser);

        //Den Berechneten Attributen werden die werte zugewiesen
        kegelObj.setRadius(auffangArray[0]);
        kegelObj.setOberflaeche(auffangArray[1]);
        kegelObj.setVolumen(auffangArray[2]);
        
        //Die Standart Attribute werden ausgegeben (eingabe)
        System.out.println(kegelObj.textInfo());
        //Die Berechneten Attribute (berechnungen) werden ausgegeben
        System.out.println("Attribute: "+ kegelObj.textInfo() + " Volumen: "+kegelObj.getVolumen()+" Oberflaeche: "+kegelObj.getOberflaeche());
        

        
    }
}