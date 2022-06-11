import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Format {
  public static void main(String[] args) {
    // NumberFormatオブジェクト取得
    NumberFormat num = NumberFormat.getInstance();
    // フォーマット化
    String str = num.format(500.00);
    System.out.println(str);
    // 文字列を数値に変換
    try {
      Number n = num.parse("500.00");
      System.out.println(n);
      // Number型をdouble型に変換
      double d = n.doubleValue();
      System.out.println(d);
    } catch (Exception e) {
      e.printStackTrace();
    }

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yy,MM,dd");
    String target = "21,12,22";
    LocalDate date = LocalDate.parse(target, fmt);
    System.out.println(date);
    LocalTime time = LocalTime.parse("22:00");
    System.out.println(time);

    customFormat("##.#", 12.3);
    customFormat("000.0", 12.3);

    LocalDate localDate = LocalDate.of(2022, 2, 15);
    System.out.println("getDayOfYear : " + localDate.getDayOfYear() + "/365");
    System.out.println("getDayOfMonth :" + localDate.getDayOfMonth());
    System.out.println("getDayOfWeek: " + localDate.getDayOfWeek());
    System.out.println("getMonth: " + localDate.getMonth());
    System.out.println("getMonthValue: " + localDate.getMonthValue());

    // ofLocalizedDateメソッド(/区切りになる)
    DateTimeFormatter fmt2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    System.out.println("ofLocalizedDate:" + fmt2.format(date));
    // ofLocalizedTimeメソッド
    DateTimeFormatter fmt3 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
    System.out.println("ofLocalizedTime:" + fmt3.format(time));
    // ofLocalizedDateTimeメソッド
    DateTimeFormatter fmt4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    // System.out.println(fmt4.format(time)); 実行時例外
    LocalDateTime now = LocalDateTime.now();
    System.out.println("ofLocalizedDateTime:" + fmt4.format(now));

  }

  // カスタムフォーマットメソッド
  public static void customFormat(String pattern, double val) {
    DecimalFormat df = new DecimalFormat(pattern);
    String data = df.format(val);
    System.out.println("(" + pattern + "," + val + "):" + data);
  }
}