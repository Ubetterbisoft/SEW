
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

    public boolean equals(Bewertung b){
        if(this.bewertung == b.getBewertung() && this.Text.equals(b.getText())){
            return true;   
        }
        return false;
    }

    @Override
    public int hashCode() {
  
        int hashCode =  (int) this.bewertung + this.Text.hashCode();
        return hashCode;
    }
}
