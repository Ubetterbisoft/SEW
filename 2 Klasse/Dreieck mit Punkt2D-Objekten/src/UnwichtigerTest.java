import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UnwichtigerTest {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\draji\\Documents\\Word\\englischbrief.txt"));
      String zeile;
      try {
        while ((zeile = br.readLine()) != null) {
          System.out.println(zeile);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }

  
  
  
  }
}
