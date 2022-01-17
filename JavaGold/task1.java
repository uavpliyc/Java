package JavaGold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class task1 {
  public static void main(String[] args) {
    
    LocalDateTime now = LocalDateTime.now();

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/user/Desktop/JavaGold/Task_1.log", true));
        BufferedReader br = new BufferedReader(new FileReader("/Users/user/Desktop/JavaGold/Task_1.log"))) {
          bw.write(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
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