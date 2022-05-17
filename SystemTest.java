import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemTest {
  public static void main(String[] args) throws IOException {
    
    try (
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ) {
      String s = br.readLine();
      System.out.println("input:" + s);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}