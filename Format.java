import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Format {
  public static void main(String[] args) {

    NumberFormat num = NumberFormat.getInstance();
    NumberFormat cur = NumberFormat.getCurrencyInstance();

    System.out.println(num.format(1000));
    System.out.println(cur.format(1000));

    ZoneId zid = ZoneId.systemDefault();
    LocalDateTime ldt = LocalDateTime.of(2022, 12, 10, 10, 30, 45);
    ZonedDateTime zdt = ZonedDateTime.of(ldt, zid);

    DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
    DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
    DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

    System.out.println(dtf1.format(zdt));
    // System.out.println(dtf1.format(ldt));
    System.out.println(dtf2.format(zdt));
    System.out.println(dtf3.format(zdt));
    System.out.println(dtf4.format(zdt));

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
    System.out.println("getYear: " + localDate.getYear());

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
    System.out.println("(" + pattern + "," + val + "):");
  }
}