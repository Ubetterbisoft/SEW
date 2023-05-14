import java.util.HashMap;
import java.util.Map.Entry;

public class Schueler implements Comparable<Schueler>{
    private int katalognummer;
    private String vorname;
    private String nachname;
    private char gruppe;
    private HashMap<Gegenstand,Integer> notenliste;
    /**
     * Default & normaler Konstruktor
     */
    public Schueler(){

    }
    public Schueler(int katalognummer,String vorname,String nachname,char gruppe){
        this.setKatalognummer(katalognummer);
        this.setVorname(vorname);
        this.setNachname(nachname);
        this.setGruppe(gruppe);
        this.notenliste = new HashMap<>();
        this.notenliste.put(Gegenstand.AM,1);
        this.notenliste.put(Gegenstand.D,1);
        this.notenliste.put(Gegenstand.E1,3);
        this.notenliste.put(Gegenstand.SYT,5);
    }

    /**
     * Setter
     * @param gruppe
     */
    public void setGruppe(char gruppe) {
        this.gruppe = gruppe;
    }

    public void setKatalognummer(int katalognummer) {
        this.katalognummer = katalognummer;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    /**
     * Getter
     */
    public char getGruppe() {
        return gruppe;
    }

    public int getKatalognummer() {
        return katalognummer;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    /**
     * Gibt alle fächer und Noten des Schülers im Stringformat zurück
     * @return die ausgabe der Notenliste als String formatiert
     */
    public String notenListe(){
        String output ="";
        int i = 0;
        for(Entry<Gegenstand,Integer> note: this.notenliste.entrySet()){
            output += note.getKey().name() +" (" + note.getKey().getDesc() + "): "+ note.getValue() +" , ";
        }
        return output;
    }

    /**
     * Gibt die Note zum gegebenen Gegenstand zurück
     * @param gegenstand übergebner Gegenstand
     * @return die Note des übergebenen Gegenstandes
     */

    public int note(Gegenstand gegenstand){
        for(Entry<Gegenstand,Integer> map: this.notenliste.entrySet()){
            if(map.getKey().equals(gegenstand))
                return map.getValue();
        }
        return -5;
    }
    public void noteHinzu(Gegenstand gegenstand, int note){
        for(Entry<Gegenstand,Integer> map: this.notenliste.entrySet()){
            if(map.getKey().equals(gegenstand)){
                map.setValue(note);
                return;
            }

        }
    }
    public String notenGelistet(){
        String output ="";
        for(Entry<Gegenstand,Integer>map: this.notenliste.entrySet()){
            output += map.getValue()+" ,";
        }
        return output;
    }

    /**
     * Hier muss nach katalognummer und Klasse überprüft werden
     * @param schueler1 the object to be compared.
     * @return
     */
    //@Override
    public int compareTo(Schueler schueler){
        if(this.equals(schueler))
            return 0;

        if(schueler == null)
            return -1;
        int ret = this.vorname.compareTo(schueler.getVorname());
        if(ret != 0){
            return ret;
        }
        ret = this.nachname.compareTo(schueler.getNachname());
        if(ret!=0)
            return ret;
        ret = this.gruppe - schueler.getGruppe();
        if(ret !=0)
            return ret;
        ret = this.katalognummer - schueler.getKatalognummer();
        if(ret !=0)
            return ret;
        return 0;
    }

    @Override
    public boolean equals(Object o){
        /**
         * Überprüüfung auf null und referenz
         */
        if(this == o)
            return true;
        if(o == null)
            return false;
        if(getClass()!= o.getClass())
            return false;

        Schueler schueler = (Schueler) o;
        /**
         * Überprüfung von Attribut "Gruppe"
         */
        if(this.gruppe == 0){
            if(schueler.getGruppe() != 0){
                return false;
            }
        }else if(!(this.gruppe == schueler.getGruppe())){
            return false;
        }
        /**
         * Überprufung von Attribut "Katalognummer"
         */
        if(this.katalognummer != schueler.getKatalognummer())
            return false;
        /**
         * Überprüfung Vor /Nachname
         */
        if(this.vorname == null){
            if(schueler.getVorname() != null){
                return false;
            }
        }else if(!this.vorname.equals(schueler.getVorname()))
            return false;

        if(this.nachname == null){
            if(schueler.getNachname() !=null)
                return false;
        }else if(!this.nachname.equals(schueler.getNachname()))
            return false;

        return true;
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = result * prime +this.gruppe;
        result = result * prime + this.katalognummer;
        result = result * prime + ((this.nachname == null) ? 0: this.nachname.hashCode());
        result = result * prime + ((this.vorname == null) ? 0: this.vorname.hashCode());

        return result;
    }



}
