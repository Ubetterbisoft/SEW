/**
 *@author Dejan RAjic
 * @version 2021-05-21
 * @ param args ist das argument
 */
import javax.swing.JOptionPane;
public class Test{
    /**
     * ist das programm
     * @author Dejan RAjic
     * @version 2021-05-21
     * @param args ist das argument
     */
    public static void main(String[] args){
        String eingabeTag = JOptionPane.showInputDialog(null, "Geben Sie den Tag ein");
        int eingabeTagInt = Integer.parseInt(eingabeTag);
        
        String eingabeMonat = JOptionPane.showInputDialog(null, "Geben Sie den Monat ein");
        int eingabeMonatInt = Integer.parseInt(eingabeMonat);

        String eingabeJahr =  JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
        int eingabeJahrInt = Integer.parseInt(eingabeJahr);

        int[] datumArray = new int[3];
        datumArray[0]= eingabeTagInt;
        datumArray[1]= eingabeMonatInt;
        datumArray[2]= eingabeJahrInt;
        System.out.println("Wochentag: "+ Datum.wochentag(datumArray));    
    } 
}