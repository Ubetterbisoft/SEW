public class Bewertung {
    private double bewertung;
    private String Text;

    public Bewertung(){
        this.bewertung = 0;
        this.Text = " / ";
    }
    
    public Bewertung(double bewertung, String Text){
        this.bewertung = bewertung;
        this.Text = Text;
    }

    public void setBewertung(double bewertung) {
        this.bewertung = bewertung;
    }
    public void setText(String text) {
        Text = text;
    }
    public double getBewertung() {
        return bewertung;
    }
    public String getText() {
        return Text;
    }

    @Override
    public String toString(){
        return "Bewertung: " + this.bewertung + " Text: " + this.Text;
    }

    @Override
    public boolean equals(Object b){
        
        //Es wird geschaut ob die Referenzen gleich sind, wenn ja dan ist es der inhalt gleich
        if(this == b){
            return true;
        }
        //Es wird geschaut ob das Objekt existiert
        if(b == null){
            return false;
        }
        //Es wird verglichen ob die Klassen gleich sind, wegen den attributen 8sie könnten unterschiedlich sein)
        if(getClass() != b.getClass()){
            return false;
        }
        Bewertung b1 = (Bewertung) b;
        if(this.bewertung == b1.getBewertung() && this.Text.equals(b1.getText())){
            return true;   
        }
        return false;
    }

    @Override
    public int hashCode() {
        //alle hashwerte werdnen
        int hashCode =  (int) this.bewertung + this.Text.hashCode();
        return hashCode;
    }
}
