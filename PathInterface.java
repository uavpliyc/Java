import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInterface {
  public static void main(String[] args) {
    Path path = Paths.get("/Users/user/Desktop/test.txt");
    // toStringメソッド
    System.out.format("toString:" + path.toString());
  }
}