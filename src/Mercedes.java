public class Mercedes extends Auto{
    private String Marke;

    public Mercedes(String Marke){
        super();
        this.Marke = Marke;
    }
    public Mercedes(){
        this("Mercedes");
    }

    @Override
    public String toString(){
        return super.toString() + " :"+this.Marke;
    }
    @Override
    public String flex(){
        return this.toString() +" Flex brrrrmmmm";
    }
}
