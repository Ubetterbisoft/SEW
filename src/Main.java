import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Auto[] auto = new Auto[5];

        //Mann kann ein Mercedes Objekt in ein Auto Array speichern weil Mercees von Auto erbt.
        auto[0] = new Auto();
        auto[1] = new Mercedes();

        //Weil ein Auto Objekt in die Objekt referenzvariable gespeichert wird
        // muss man die variable in Auto umcasten damit sie in den Auto[] gespeichert werden kann
        //dadurch erhält man zugriff auf alle Objektmethoden der Klasse Auto welche vorher verdeckt waren
        Object obj = new Auto();
        auto[2] = (Auto) obj;


        for(int i = 0; i< auto.length;i++){
            if(auto[i] != null)
                //Kommt drauf an ob ein Auto oder Mercedes Objekt gespeichert ist. Bei Auto wird ein Auto toString, bei Mercedes ein Mercedes toString
                //verwendent (Polymorphie)
                System.out.println(auto[i].toString());
            else{
                System.out.println("");
            }
        }
        System.out.println(auto[1].flex());
        Auto auto1 = new Mercedes("Mercedes c180");
        System.out.println(auto1.toString());

        //Testen der Speichern Laden Methoden

        try {
            auto[0].speichern();
        } catch (IOException e) {
            System.err.println("Ein Fehler beim Speichern Aufgetreten");
        }

    }
}