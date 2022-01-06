import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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

    // BufferedWriter BufferedReader

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/user/Desktop/test.txt"));
      BufferedReader br = new BufferedReader(new FileReader("/Users/user/Desktop/test.txt"))) {
        bw.write("good morning");
        // newLineメソッド：１行追加
        bw.newLine();
        bw.write("hello");
        // flushメソッド：入力値を反映させる
        bw.flush();
        String data2 = null;
        while ((data2 = br.readLine()) != null) {
          System.out.println(data2);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    try (BufferedReader br = new BufferedReader(new FileReader("/Users/user/Desktop/test.txt"))) {
      System.out.println(br.readLine());
      br.skip(2);
      System.out.println(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    }
}