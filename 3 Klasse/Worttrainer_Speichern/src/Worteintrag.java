import java.net.URL;

/**
 * Erstellt einen Worteintrag und bietet grundfunktionalitäten
 * @author draji
 * @version 2022.09.22
 */
public class Worteintrag {

    private String wort;

    private String url;

    public Worteintrag(String wort, String url) {
        if(wort.length() < 3) {
            throw new IllegalArgumentException("Class Worteintrag at Constructor; zu kurzes Wort");

        }
        this.wort = wort;
        this.url = url;
    }


    /**
     * checkt die Url mit dem begin (https:// / http://) und nach den domains und subdomains
     * @param url die übergebene Url als String
     * @return ob es übereinstimmt oder nicht
     */



    public static boolean checkURL(String url) {
        try{
            new URL(url).toURI();

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * Das wort wird nur gesetz wenn es länger als 2 Zeichen ist
     * @param wort das zu setzende Wort
     */
    public void setWort(String wort) {
        if(wort == null || wort.length() < 2){
            throw new IllegalArgumentException("set Wort: wort passt nicht");
        }
        this.wort = wort;
    }

    /**
     * Die Url wird gesetz und auf gültigkeit überprüft
     * @param url
     */
    public void setUrl(String url) {
        if(url == null || this.checkURL(url) == false){
            throw new IllegalArgumentException("Die Url entspricht nicht den Vorgaben");
        }
        this.url = url;
    }

    public String getWort() {
        return wort;
    }

    public String getUrl() {
        return url;
    }

    public String toString() {
        return this.wort +" ; "+ this.url;
    }

}
