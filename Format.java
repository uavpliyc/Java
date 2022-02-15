import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    customFormat("##.#", 12.3);
    customFormat("000.0", 12.3);

    LocalDate localDate = LocalDate.of(2022, 2, 15);
    System.out.println(localDate.getDayOfYear() + "/365");
    System.out.println(localDate.getDayOfMonth());
    System.out.println(localDate.getDayOfWeek());

  }

  // カスタムフォーマットメソッド
  public static void customFormat(String pattern, double val) {
    DecimalFormat df = new DecimalFormat(pattern);
    String data = df.format(val);
    System.out.println(data);
  }
}