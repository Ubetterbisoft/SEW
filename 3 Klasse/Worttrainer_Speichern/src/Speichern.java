import java.io.*;
import java.io.IOException;

public class Speichern {


    public void speichern(String Pfad, WortTrainer wortTrainer) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(Pfad));
            writer.write("WortEinträge:\n");
            writer.write(wortTrainer.getWortListe().toString());
            writer.write("\nStatistik der Wörter:\n" + wortTrainer.statistik());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

    }
    public void speichern() throws  IOException{

        WortTrainer wortTrainer = new WortTrainer();
        speichern("WortTrainerDefault.txt",wortTrainer);
    }

    public void laden(String Pfad) throws  IOException{
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(Pfad));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            reader.close();
        }
    }
    public void laden()throws IOException{
        laden("WortTrainerDefault.txt");
    }
}
