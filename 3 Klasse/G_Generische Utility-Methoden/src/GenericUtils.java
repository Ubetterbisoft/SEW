public class GenericUtils <T>{

    //der Generische Datentyp muss vor dem Rückgabetyp stehen
    public static <T> void umdrehen(T[] array){
        for(int i = 0; i < array.length/2; i++){
            //erste stelle von array wird genommen
            T temp = array[i];
            //prototyp letze stelle wird in array gegeben
            array[i] = array[array.length-i-1];

            array[array.length-i-1] = temp;
        }
        
    }
    
    public static void main(String[] args) {
        String [] a = {"a","b","c","d","e"};
        umdrehen(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
