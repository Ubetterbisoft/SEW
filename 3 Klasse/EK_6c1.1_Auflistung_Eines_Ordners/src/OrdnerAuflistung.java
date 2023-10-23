import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dieses Programm erhält einen Pfad als parameter und iteriert durch den Ordner und gibt alle elemente samt unterordner an
 * @author Dejan Rajic
 * @version 14.06.2023
 */
public class OrdnerAuflistung {
    public static String listFile(File file, int depth){
        String output = "";
        File[] fileArray = file.listFiles();
        for(int i = 0; i < fileArray.length;i++){
            if(fileArray[i].isDirectory()){
                output += "     ".repeat(depth)+" + "+ fileArray[i].getName()+"\n";
                output += listFile(fileArray[i],depth+1);
            }
            if(fileArray[i].isFile()){
                output += "     ".repeat(depth)+fileArray[i].getName()+" - "+ new SimpleDateFormat("dd.MM.yyyy").format(new Date(file.lastModified()))+" - "+ fileArray[i].length() +"Byte" +"\n";
            }


        }
        return output;
    }

    public static void main(String[]args){
        File ordner = new File("C:\\Users\\draji\\OneDrive\\Desktop\\Github\\SEW\\3 Klasse\\EK_6c1.1_Auflistung_Eines_Ordners");
        int depth =0;
        System.out.println(listFile(ordner,depth));
    }
}
