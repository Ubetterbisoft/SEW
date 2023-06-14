import java.io.File;

public class OrdnerAuflistung {
    public static String listFile(File file,String output){
        File[] fileArray = file.listFiles();
        for(int i = 0; i < fileArray.length;i++){
            if(fileArray[i].isDirectory()){
                output += "+" + fileArray[i].getName()+"\n";
                output += listFile(fileArray[i],output);
            }
            if(fileArray[i].isFile()){
                output += fileArray[i].getName()+"\n";
            }


        }
        return output;
    }

    public static void main(String[]args){
        File ordner = new File("C:\\Users\\draji\\OneDrive\\Desktop\\Github\\SEW\\3 Klasse\\EK_6c1.1_Auflistung_Eines_Ordners");
        String output = "";
        System.out.println(listFile(ordner,output));
    }
}
