import java.io.*;
import java.io.IOException;

public class Speichern {


    public void speichernWortTrainer(String Pfad, WortTrainer wortTrainer) throws IOException {
        File f = new File("saveWortTrainer");
        FileWriter outputStream = null;

        /**
         * speichert die wortliste und statistik
         */
        try{
            outputStream = new FileWriter(f);
            for(int i = 0; i < wortTrainer.getWortListe().getWorteinträge().length;i++){
                outputStream.write(wortTrainer.getWortListe().toString());
                outputStream.write(System.lineSeparator());
            }
            outputStream.write(wortTrainer.statistik());
            outputStream.write(System.lineSeparator());
        }finally{
            if(outputStream != null)
                outputStream.close();
        }

    }
}
