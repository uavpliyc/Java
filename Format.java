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


    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yy,MM,dd");
    String target = "21,12,22";
    LocalDate date = LocalDate.parse(target, fmt);
    System.out.println(date);
  }
}