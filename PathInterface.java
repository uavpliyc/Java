import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInterface {
  public static void main(String[] args) {
    Path path = Paths.get("/Users/user/Desktop/test.txt");
    // toStringメソッド
    System.out.format("toString: %s%n" , path.toString());
    // getFileNameメソッド
    System.out.format("getFileName: %s%n" , path.getFileName());
    // getNameメソッド：ルートパスから引数の数の要素を返す
    System.out.format("getName: %s%n" , path.getName(0));
    // getNameCountメソッド
    System.out.format("getNameCount: %s%n" , path.getNameCount());
    // getRootメソッド
    System.out.format("getRoot: %s%n" , path.getRoot());

    // walkメソッド：指定ディレクトリ以下の探索
    try {
      Files.walk(path).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(path.normalize());

  }
}