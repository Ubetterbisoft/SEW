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

    public String bewertungDaten(){
        return "Bewertung: " + this.bewertung + "\nText: " + this.Text;
    }
}
