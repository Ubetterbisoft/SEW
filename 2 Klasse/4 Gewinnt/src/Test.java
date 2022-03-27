public class Test {
    public static void main(String[] args){
        Chip chipRot = new Chip("Rot");
        VierGewinnt spielfeld = new VierGewinnt();
        //für das einwerfen muss man von den indexen aus gehen sowohl vertikal 
        //als auch horizontal
        spielfeld.add(0,Chip.ROT);
        spielfeld.add(0,chipRot);
        spielfeld.add(0,chipRot);
        spielfeld.add(0,chipRot);
        System.out.println(spielfeld.anzeige());
        System.out.println(spielfeld.checkGewinn(2, 0));
        spielfeld.deleteLast(0);
        spielfeld.set(3, 4, chipRot);
        System.out.println(spielfeld.anzeige());
        spielfeld.deleteAll("Rot");
        System.out.println(spielfeld.anzeige());
        VierGewinnt spielfeld2 = new VierGewinnt();
        System.out.println(spielfeld.equals(spielfeld2));
        spielfeld.add(0,chipRot);
        spielfeld.add(0,chipRot);
        spielfeld.add(0,chipRot);
        VierGewinnt clone = spielfeld.clone();
    }
}
