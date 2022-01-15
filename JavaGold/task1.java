package JavaGold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Properties;

public class task1 {
  public static void main(String[] args) {
    
    try (FileOutputStream fos = new FileOutputStream(new File("/Users/user/Desktop/JavaGold/Task_1.log"), true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"))) {
      LocalDateTime now = LocalDateTime.now();
      fos.write(0);
      fos.write(now.getMonth().getValue());
      fos.write(now.getDayOfMonth());
      fos.write("test".getBytes());
      fos.write(99);
    } catch (FileNotFoundException e) {
      System.out.println("ファイルがありません");
    } catch (IOException e) {
      System.out.println("IO Error");
    }

    try (
      BufferedReader brLog = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/Desktop/JavaGold/Task_1.log"), Charset.forName("UTF-8")));
      BufferedReader brTxt = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/Desktop/JavaGold/Task1.txt"), Charset.forName("UTF-8")));
      BufferedReader brCsv = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/Desktop/JavaGold/Task1.csv"), Charset.forName("UTF-8")));
      BufferedReader brTsv = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/Desktop/JavaGold/Task1.tsv"), Charset.forName("UTF-8")));
      BufferedReader brSsv = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/user/Desktop/JavaGold/Task1.ssv"), Charset.forName("UTF-8")))
    ) {
      String text;
      while((text = brLog.readLine()) != null) {
        System.out.println(text);
      }

      File dir = new File("/Users/user/Desktop/JavaGold");

      File[] list = dir.listFiles();
      if (list != null) {
        for (int i = 0; i < list.length; i++) {
          if (list[i].isFile()) {
            System.out.println("[F] : " + list[i].toString());
          } else if (list[i].isDirectory()) {
            System.out.println("[D] : " + list[i].toString());
          }
        }
      } else {
        System.out.println("null");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      FileReader pFile = new FileReader("task2.properties");
      Properties p = new Properties();
      p.load(pFile);
      System.out.println(p.getProperty("unicode"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}