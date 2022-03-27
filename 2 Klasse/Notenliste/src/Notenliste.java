/**
 * Das Programm arbeitet mit noten und liefert bearbeitungsmöglichkeiten für diese
 * @author Dejan Rajic
 * @version 2021-11-18
 */
public class Notenliste {
    private int notenArray[];
    Notenliste(int moeglicheNoten){
        this.notenArray =  new int [moeglicheNoten];
        for(int i = 1; i < notenArray.length +1;i++){
            notenArray[i-1] = 0;
            
            
        }
    }
    public void setNotenArray(int[] notenArray) {
        this.notenArray = notenArray;
    }
    public int[] getNotenArray() {
        return notenArray;
    }
    /**
     * überprüft ob die note im passenden Bereich liegt
     * @param note ist die übergebene NOte
     * @return wahr oder falsch
     */
    public boolean checkNote(int note){
        if(note > 0 && note < 6){
            return true;
        } 
        return false;
    }
    /**
     * Ändert die Note an der Stelle des Index
     * @param note die Note
     * @param index der Index
     * @return  wahr oder falsch
     */
    public boolean setNote(int note, int index){
        this.notenArray[index] = note;
        if(this.checkNote(note) == true && this.checkNote(index -1)){
            notenArray[index] = note;
            return true;
        }
        return false;
    }
    /**
     * Ändert die Note an der Stelle des Index
     * @param note die Note
     * @return  wahr oder falsch
     */
    public boolean addNote(int note){
        for(int i = 1; i < notenArray.length;i++ ){
            if(notenArray[i] == 0){
                notenArray[i] = note;
                return true;
            }
        }
        return false;
    }
    /**
     * Setz die Note an der stelle des index gleidch null
     * @param index der index
     * @return wahr oder falsch
     */
    public boolean deleteNote(int index){
        if(index > -1 && index < 5){
            notenArray[index] = 0;
            return true;
        }
        return false;
    }
    /**
     * Berechnet den Notendurchschnitt valider noten
     * @return der NOtendurchschnitt
     */
    public double durchschnitt(){
        int addition = 0;
        for(int i = 0; i < notenArray.length;i++){
            if(this.checkNote(notenArray[i])){
                addition += notenArray[i];
            }
        }
        double notenDurchschnitt = (double) addition / notenArray.length;
        return notenDurchschnitt;
        
    }
    /**
     * Gibt die Noten mit dem dazugehörigem notendurchschnitt aus
     * @return das ergebnis
     */
    public String notenListe(){
        String Ausgabe ="";
        int i = 1;
        for(;i < notenArray.length +1;i++){
            if(this.checkNote(notenArray[i -1])){
                Ausgabe += (notenArray[i -1] + ", ");
                
            }
            
        }
        //Funktioniert so nur wenn man fünf gültige noten hat, Wenn man eine gültige note weniger hat muss man den indes von substring 
        // umd die dementsprechene zahl der vehlenden noten verringern dann funktioniert es einwandfrei
        Ausgabe = Ausgabe.substring(0,13) + ("- " + this.durchschnitt());
        return Ausgabe;
    }
    

}
