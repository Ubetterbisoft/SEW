 public class Datum {
    public static String wochentagText(int i){
        if(i > -1 && i < 7){
            String[] wochentag = {"Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"};
            return wochentag[i -2];
        }
        return "Sie haben einen nicht existenten wochentag ausgewählt";
    }
    public static String wochentag(int[] datum) {
        if(datum[1] <=2)   {
            datum[1] = datum[1] + 10;
            datum[2] = datum[2] -1;
            
        } else {
            datum[1] = datum[1] -2;
        }
        int a = datum[2]/100;
        int b = datum[2]%100;
        int c = ((26*datum[2] -2)/10+datum[0]+b+b/4+a/4-2*a)%7;
        if(c < 0)   {
            c = c + 7;
        }
        return wochentagText(c);
    }
}
