public class Auto {
     private String nameA;
     private int baujahr;
     private double ps;





     public Auto(String name,int baujahr,double ps) {
         this.name = name;
         this.baujahr = baujahr;
     }
     @Override
    public String toString(){
         String ausgabe = " " + name + baujahr + ps;
         return ausgabe;
     }
}
