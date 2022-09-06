package JavaGold;

import java.util.Calendar;
import java.util.logging.Logger;


public class task1 {
  public static void main(String[] args) {
    
    Logging.outputToLog();
    Logging.startTime();
    Logging.ReadAndWrite();

    BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());
    Calendar from = Calendar.getInstance();
    Calendar cal = null;
    String date = null;

    // fromから10日後
    cal = bdc.getDate(from, 10);
    date = cal.get(Calendar.YEAR) + "/" +
      (cal.get(Calendar.MONTH) + 1) + "/" +
    cal.get(Calendar.DAY_OF_MONTH);
    System.out.println(date);

    OutputName on = new OutputName();
    on.OutputFirstName();
    on.OutputFamilyName();

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