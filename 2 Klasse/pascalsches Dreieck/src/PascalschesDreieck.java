/**
 * Klasse PascalschesDreieck
 * @author Rajic Dejan
 * @version 17.01.2022
 */
public class PascalschesDreieck {
    /**
     * Erstellt ein 2D Array mit einem Pascalschem Dreieck
     * @param x Anzahl der Zeilen
     * @return das Dreieck
     */
    public static int[][] pascal(int x) {
        int [][] array = new int [x][x];
        for (int n = 0; n < x; n++) {
            for (int k = 0; k <= n; k++){
                //Wenn k == 0 und k == n, dann ist die spalte ganz links  oder rechts gemeint und die ist immer 1, deswegen wird das Element
                //des Arrays auf 1 gesetz. 
                if ( k == 0 || k == n) {
                    array[n][k]	= 1;
                }
                else {
                    //Binomialkoeffizienten werden berechnet
                    // Die beiden Zahlen über der zahl werden berechnet
                    array[n][k] = array[n - 1][k - 1] + array[n - 1][k];
                }
            }
        }
        return array;
    }

    /**
     * Wandelt das Array in einen String.
     * @param pascal das Dreieck
     * @return den String
     */
    public static String arrayToString(int[][]pascal) {
        String txt = "";
        for(int n=0; n < pascal.length; n++){
            for (int k=0; k <= n; k++){
                txt+= pascal[n][k]+" ";
            }
            txt+="\n";
        }
        return txt;
    }
}
