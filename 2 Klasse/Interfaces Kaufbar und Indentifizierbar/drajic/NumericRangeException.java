public class NumericRangeException extends Exception{
    public NumericRangeException(){
        super(" Der Angegebene Parameter ist auserhalb des Wertebereichs");
    }
    public NumericRangeException(String Message){
        super(Message);
    }
}