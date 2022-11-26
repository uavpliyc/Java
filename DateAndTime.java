import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;

public class DateAndTime {
  public static void main(String[] args) {

    // 夏時間
    ZoneId z = ZoneId.of("America/Los_Angeles");
    LocalDate date = LocalDate.of(2022, 3, 13);
    LocalTime time1 = LocalTime.of(1, 00);
    LocalTime time2 = LocalTime.of(2, 00);
    ZonedDateTime zdatetime1 = ZonedDateTime.of(date, time1, z);
    ZonedDateTime zdatetime2 = ZonedDateTime.of(date, time2, z);

    System.out.println(zdatetime1);
    System.out.println(zdatetime2);

    //コンストラクタがprivateなのでインスタンス生成はできない

    LocalDate dd = LocalDate.now();
    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MMMM");
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMMM", Locale.US);
    System.out.println(dd.format(dtf1));
    System.out.println(dd.format(dtf2));

    // java.timeパッケージ2つの列挙型(MONDAY〜SUNDAYとJANUARY〜DECEMBER)
    for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
      System.out.println(dayOfWeek);
    }
    for (Month month : Month.values()) {
      System.out.println(month);
    }
    LocalDate ld = LocalDate.of(2022, Month.JANUARY, 01);
    Month m = ld.getMonth();
    // Month m = d.getMonthValue();
    System.out.println(m);

    // -----------------------「LocalDateクラス」--------------------------------

    LocalDate now = LocalDate.now();
    System.out.println(now);

    // ofメソッド：年、月、日からLocalDateオブジェクトを取得(１桁も可能)
    LocalDate ofDate = LocalDate.of(2022, 3, 26);
    System.out.println(ofDate);

    // parseメソッド：文字列からLocalDateオブジェクトを取得(１桁は実行時エラー)
    LocalDate ofDate2 = LocalDate.parse("2022-03-26");
    System.out.println(ofDate2);

    // getMonthメソッド：英語で月
    System.out.println(ofDate.getMonth());

    // getMonthValueメソッド：数字で月
    System.out.println(ofDate.getMonthValue());

    Date d = new Date();
    System.out.println(d);

    LocalDate start = LocalDate.of(2021, Month.JANUARY, 1);
    LocalDate end = LocalDate.of(2021, Month.JANUARY, 20);
    // Periodクラスのbetweenメソッド
    Period period = Period.between(start, end);
    System.out.println("period:" + period);
    // TemporalUnitインターフェースの実装クラスChronoUnitのbetweenメソッド
    long days = ChronoUnit.DAYS.between(start, end);
    System.out.println("ChronoUnit:" + days);

    // addTo
    Temporal t = ChronoUnit.DAYS.addTo(start, 5);
    System.out.println(t);

    System.out.println("minusDays: " + start.minusDays(2));

    // -----------------------「LocalTimeクラス」--------------------------------

    LocalTime nowTime = LocalTime.now();
    System.out.println(nowTime);

    // ofメソッド：時、分、秒、ナノ秒
    LocalTime ofTime = LocalTime.of(9, 20, 30, 180);
    System.out.println(ofTime);

    // -----------------------「LocalDateTimeクラス」--------------------------------

    // ofメソッド：年、月、日、時、分、秒、ナノ秒
    LocalDateTime ofDateTime = LocalDateTime.of(2022, 3, 26, 9, 30, 45, 180);
    System.out.println(ofDateTime);

    // LocalDateとLocalTimeを利用
    LocalDateTime ofDateTime2 = LocalDateTime.of(ofDate, ofTime);
    System.out.println(ofDateTime2);

    // -----------------------「LocalDateFormatterクラス」--------------------------------

    // formatメソッド：特定フォーマットで返す
    DateTimeFormatter fmt1 = DateTimeFormatter.ISO_DATE;
    DateTimeFormatter fmt2 = DateTimeFormatter.ISO_TIME;
    DateTimeFormatter fmt3 = DateTimeFormatter.ISO_DATE_TIME;
    DateTimeFormatter fmt4 = DateTimeFormatter.ISO_LOCAL_DATE;
    DateTimeFormatter fmt5 = DateTimeFormatter.BASIC_ISO_DATE;
    System.out.println("ISO_DATE: " + fmt1.format(ofDateTime));
    System.out.println("ISO_TIME: " + fmt2.format(ofDateTime));
    System.out.println("ISO_DATE_TIME: " + fmt3.format(ofDateTime));
    System.out.println("ISO_LOCAL_DATE: " + fmt4.format(ofDateTime));
    System.out.println("BASIC_ISO_DATE: " + fmt5.format(ofDateTime));

    // ofPatternメソッド：独自のフォーマット(「/」で区切る時とか)
    DateTimeFormatter myFmt = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter myFmt2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    System.out.println(now.format(myFmt));
    System.out.println(now.format(myFmt2));

    // ロケール固有のフォーマッタを返す
    // DateTimeFormatter dtfmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    // System.out.println(now.format(dtfmt));

    // -----------------------「ZoneDateTimeクラス」--------------------------------

    // ZoneIdクラス：タイムゾーンID(+09:00は協定世界時との時差)
    // systemDefaultメソッド
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zone = ZonedDateTime.of(ofDateTime, zoneId);
    System.out.println(zone);

    ZoneId zoneId2 = ZoneId.of("America/Los_Angeles");
    ZonedDateTime zone2 = ZonedDateTime.of(2022,12,10,10,30,45,180,zoneId2);
    System.out.println(zone2);

    // -----------------------「OffSetDateTimeクラス」--------------------------------

    // ZoneOffSetクラス：タイムゾーンID(+09:00は協定世界時との時差)
    // systemDefaultメソッド
    ZoneOffset zoneoff = ZoneOffset.of("+09:00");
    OffsetDateTime offset = OffsetDateTime.of(ofDateTime, zoneoff);
    System.out.println(offset);

    // -----------------------「Periodクラス」--------------------------------

    // betweenメソッド：第１と第２の差(P:Period,Y:Year,M:Month,D:Date)
    LocalDate futureDate = LocalDate.of(2025, 3, 26);
    Period pe = Period.between(now, futureDate);
    System.out.println(pe);

    // -----------------------「DateTimeクラス」--------------------------------
    DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("yy,MM,dd");
    System.out.println("dFormatter: " + dFormatter.getLocale());
    // parseメソッド：第1引数String、第2引数DateTimeFormatter
    System.out.println(LocalDate.parse("22,03,24", dFormatter));
  }
}