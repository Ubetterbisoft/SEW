/**
 * Hier wird das objekt erstellt und die methoden getestet
 * @author Dejan Rajic
 * @version 2021-11-18
 **/
public class Test {
    public static void main(String[]args){
        Notenliste noten = new Notenliste(5);
        int[] noten1 = {1,5,5,3,3};
        noten.setNotenArray(noten1);;
        System.out.println(noten.notenListe());
        System.out.println(noten.durchschnitt());
    }
}
