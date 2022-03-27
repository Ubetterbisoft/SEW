import javax.swing.JOptionPane;
public class EinAusgabe{
    public static void main(String[] args) {
        int Anzahl = Integer.parseInt(JOptionPane.showInputDialog(null,"Geben Sie die Anzahl der Stellen im Array ein"));
        int[] myNumbers = ArrayMethoden.zufallsArray(Anzahl);
        System.out.println(ArrayMethoden.arrayToText(myNumbers));
        
    } 
}
   