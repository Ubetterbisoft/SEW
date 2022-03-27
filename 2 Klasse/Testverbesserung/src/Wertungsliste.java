public class Wertungsliste{
    private Wertung[] wListe;

    Wertungsliste(int maxAnzahl){
        wListe = new Wertung[maxAnzahl];
    }
    //Wenn die erste stelle im obj frei ist wird der Parameter reingespeichert
    public boolean addWertung(Wertung wertung){
        if(wListe[0] == null){
            wListe[0] = wertung;
            return true;
        }    
        return false;
            
    }
    //Es wird zusätzlich die Attribute aktualisiert
    public boolean addWertung(String Name, int punkte){
        if(this.addWertung(wListe[0]) == true){
            wListe[0].setName(Name);
            wListe[0].setPunkte(punkte);
        }
       return false;
    }
    //alle obj's mit zu wenig punkten werden gelöscht
    public void loescheUnter(double punkte){
        for(int i = 0; i < wListe.length; i++){
            if(wListe[i].getPunkte() < punkte){
                wListe[i] = null;
            }
        }
    }
    //String ausgabe won wListe
    public String listentext(){
        String ausgabe ="";
        for(int i = 0; i < wListe.length; i++){
            if(wListe[i] != null){
                ausgabe = "" + wListe[i] + "; ";
            }
        }
        return ausgabe;
    }
    
}