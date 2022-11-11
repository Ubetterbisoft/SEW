import java.io.*;
import java.io.IOException;

public class Speichern {


    public void speichern(String Pfad, WortTrainer wortTrainer) throws IOException{
       try{
           BufferedWriter writer = new BufferedWriter(new FileWriter(Pfad));
           writer.write("WortEinträge:\n");
           writer.write(wortTrainer.getWortListe().toString());
           writer.write("\nStatistik der Wörter:\n" + wortTrainer.statistik());
           writer.close();
       }catch(IOException e){
           e.printStackTrace();
       }

    }
    public void speichern() throws  IOException{

        WortTrainer wortTrainer = new WortTrainer();
        speichern("C:\\Users\\draji\\Desktop\\Github\\SEW\\3 Klasse\\Worttrainer_Speichern\\WortTrainerDefault.txt",wortTrainer);
    }

    public void laden(String Pfad) throws  IOException{
        try{
            BufferedReader reader = new BufferedReader(new FileReader(Pfad));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void laden()throws IOException{
        laden("C:\\Users\\draji\\Desktop\\Github\\SEW\\3 Klasse\\Worttrainer_Speichern\\WortTrainerDefault.txt");
    }
}
