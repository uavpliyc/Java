import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
    // getParentメソッド：１階層上のオブジェクト(/Users/user/Desktop)
    System.out.println(path.getParent());
    // subPathメソッド：開始から終わりまでのパスを返す(0スタート、終わり含まない)
    System.out.println("subPath: " + path.subpath(1, 3));
    // normalizeメソッド：パスを簡潔に
    System.out.println("normalize: " + path.normalize());
    // resolveメソッド：絶対パスなら引数そのまま返す
    System.out.println("resolve絶対パス： " + path.resolve("/Users/user/"));
    // resolveSiblingメソッド：現在の親ディレクトリからのパスに結合して返す
    System.out.println("resolveSibling相対パス： " + path.resolveSibling("other"));

    // FilesクラスのgetAttributeメソッド：第2引数の属性を取得
    try {
      long fileSize = (long)Files.getAttribute(path, "size");
      System.out.println("Files.getAttribute: %s%n" + fileSize);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Filesクラスのwalkメソッド：指定ディレクトリ以下の探索
    try {
      Files.walk(path).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Filesクラスのlinesメソッド：ファイル内容をStreamオブジェクトとして取得
    try (Stream<String> stream = Files.lines(path)) {
      stream.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}