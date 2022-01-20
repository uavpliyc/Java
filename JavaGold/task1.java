package JavaGold;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class task1 {
  public static void main(String[] args) {
    
    Logging.outputToLog();
    Logging.inputFromFile();

      File dir = new File("/Users/user/Desktop/JavaGold");

      File[] list = dir.listFiles();
      if (list != null) {
        for (int i = 0; i < list.length; i++) {
          if (list[i].isFile()) {
            System.out.println("[File] : " + list[i].toString());
            String fileName = list[i].getName();
            // 拡張子取得
            String extension = fileName.substring(fileName.lastIndexOf("."));
            switch(extension) {
              case "txt":
                break;
              case "ssv":
                break;
              case "tsv":
                break;
              case "csv":
                break;
            }
          } else if (list[i].isDirectory()) {
            System.out.println("[Directory] : " + list[i].toString());
          }
        }
      } else {
        System.out.println("null");
      }

    final Logger logger = Logger.getLogger("Logging");

    logger.finest("隣の客はよく柿食う客だ。");
    logger.finer("東京都特許許可局。");
    logger.fine("かえるぴょこぴょこ。");
    logger.config("庭には二羽鶏が。");
    logger.info("生麦生米生卵。");
    logger.warning("あかまきがみ。");
    logger.severe("すもももももももものうち。");

  }
}