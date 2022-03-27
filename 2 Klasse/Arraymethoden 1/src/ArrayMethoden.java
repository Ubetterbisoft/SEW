
public class ArrayMethoden {
    public static int[] zufallsArray(int Stelle){
        int[] zA = new int[Stelle];
        for(int i = 0; i < zA.length; i++){
            zA[i] = (int) Math.random() *Stelle *2; 
        }
        return zA;
    }

    public static String arrayToText(int[] array){
        String arrText = "";
        for(int i = 0; i < array.length; i++){
            arrText += array[i] +", ";
        }
        return arrText;
    }
    
}