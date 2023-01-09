import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
   //um zu speichern muss er in eine txt schreiben = Buffered Writer
    public void speichern() throws IOException {
        //File(Dateiname) falls eine Datei erstellt werden muss oder File(Path) falls eine Datei bereits existiert.
        File file = new File("Autozustand.txt");
        BufferedWriter writer = null;
        try{
            //writer = new BufferedWriter(new FileWriter(file,true)); macht das der Inhalt der vorher in der Datei war nicht überschrieben und gelöscht wird. Es wird
            //der neue inhalt dazugefügt.
            writer = new BufferedWriter(new FileWriter(file,true));
            writer.write("Geschwindigkeit: "+this.Geschwindigkeit+"\nLänge: "+this.laenge+"\nHöhe: "+this.hoehe);
            writer.write(System.lineSeparator());
        }catch(IOException e){
            e.printStackTrace();
            e.toString();
        }finally{
            writer.flush();
            writer.close();
        }

    }
}
