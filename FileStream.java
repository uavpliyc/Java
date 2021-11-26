import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
  public static void main(String[] args) {
    try (FileOutputStream fos = new FileOutputStream(new File("/Users/user/Desktop/test.txt"));
        FileInputStream fis = new FileInputStream(new File("/Users/user/Desktop/test.txt"))) {
        fos.write(0);
        fos.write("suzuki".getBytes());
        fos.write(99);

        int data = 0;

        while ((data = fis.read()) != -1) {
          System.out.println(data + "");
        }
      } catch (FileNotFoundException e) {
          System.out.println("ファイルがありません");
      } catch (IOException e) {
          System.err.println("IO Error");
      }
  }
}