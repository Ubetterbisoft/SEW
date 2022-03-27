import javax.swing.JOptionPane;
public class PasswortCheck{
    public static void main(String[]args)   {
        boolean vergleich;
        do{
            String eingabe = JOptionPane.showInputDialog(null,"Geben Sie ihre Zeichen ein");
            eingabe = eingabe.toLowerCase();
            vergleich = istPasswortGueltig(eingabe,);
        }while(vergleich == true);
        
        
    }
    public static boolean istZeichenGueltig(char eingabe){
        if((eingabe >= 0)&&(eingabe <= 9)){
            return true;
        }
        if((eingabe >= 'a')&&(eingabe <= 'z')){
           return true; 
        }
        
        return false;
    }
    public static boolean istZeichenGueltig(char eingabe,boolean wert){
        if(wert == false){
            istZeichenGueltig(eingabe);
        }else{
            if((eingabe == '!')||(eingabe =='@')||(eingabe == '$')||(eingabe =='/')||(eingabe == '=')||(eingabe =='?')||(eingabe =='+')||(eingabe =='~')||(eingabe == '#')||(eingabe =='_')||(eingabe =='.')||(eingabe==';')||(eingabe ==':')||(eingabe =='{')||(eingabe =='}')||(eingabe =='|')){
                return true;
            }
            
        }
        return false;

    }
    public static boolean istPasswortGueltig(String eingabe,boolean wert ){
        for(int i = 0; i < eingabe.length();i++){
            char character = eingabe.charAt(i);
            boolean auffang = istZeichenGueltig(character,wert);
            if(auffang == false){
                return false;
            }   
        }
        return true;
    }
    
}