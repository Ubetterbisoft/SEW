public class ZahlenArray{
    private int[] zahlen;

    public void setZahlen(int[] zahlen) {
        this.zahlen = zahlen;
    }
    public int[] getZahlen() {
        return zahlen;
    }
    public void zufallsArray(int stelle){
        int[] myNumbers = new int[stelle];
        for(int i = 1; i < myNumbers.length; i++){
            myNumbers[i] = (int)Math.random()*(stelle*2);
        }
        for(int i = 1; i < myNumbers.length; i++){
            System.out.print(myNumbers[i]+",");
        }
        setZahlen(myNumbers);
        
    }

    public ZahlenArray(){
        int[] zahlen = new int[5];
        this.zahlen = zahlen;
    }
    public ZahlenArray(int stelle){
        int[] zahlen = new int[stelle];
        this.zahlen = zahlen;
    }

    public String arrayToText(){
        String ergebnis ="";
        for(int i =0; i < this.zahlen.length;i++){
            ergebnis += this.zahlen[i] + ",";
        }
        return  ergebnis;
    }

    public void umdrehen(){
        System.out.print("[");
        for(int i = this.zahlen.length -1; i >=0;i--){
            System.out.print(zahlen[i]+", ");
        }
        System.out.print(zahlen[0]+"]");
    }
}