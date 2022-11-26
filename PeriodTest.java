import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {
  public static void main(String[] args) {

    LocalDate sDate = LocalDate.of(2021, 10, 1);
    LocalDate eDate = LocalDate.of(2022, 12, 10);

    Period p = Period.between(sDate, eDate);
    System.out.println(p);
    System.out.println(p.getMonths());

    LocalDateTime dateTime = LocalDateTime.of(2022, 12, 20, 10, 30, 45);
    Period period = Period.ofDays(15);
    System.out.println(dateTime.minus(period));

    // Period：年月日
    Period p1 = Period.ofYears(3);
    System.out.println("ofYears：" + p1);
    Period p3 = Period.ofMonths(3);
    System.out.println("ofMonths：" + p3);
    Period p4 = Period.ofWeeks(3);
    System.out.println("ofWeeks：" + p4);
    // ofで繋げると最後のみ反映
    // Period p5 = Period.ofYears(3).ofMonths(1);

    // 0は表示されない
    Period p2 = Period.of(0, 10, 50);
    System.out.println("of：" + p2);
    Period p6 = Period.of(1, 10, 50);
    System.out.println("of：" + p6);

    // Duration：時分秒

    LocalTime sTime = LocalTime.of(9, 30, 45);
    LocalTime eTime = LocalTime.of(18, 50, 50);

    Duration d = Duration.between(sTime, eTime);
    System.out.println(d);
    System.out.println(d.getSeconds());

    Duration d1 = Duration.ofDays(1);
    System.out.println("ofDays：" + d1);

    Duration d2 = Duration.of(1, ChronoUnit.DAYS);
    Duration d3 = Duration.of(1, ChronoUnit.HOURS);
    Duration d4 = Duration.of(1, ChronoUnit.MINUTES);
    Duration d5 = Duration.of(1, ChronoUnit.SECONDS);
    Duration d6 = Duration.of(1, ChronoUnit.MILLIS);
    Duration d7 = Duration.of(1, ChronoUnit.NANOS);
    System.out.println("DAYS：" + d2);
    System.out.println("HOURS：" + d3);
    System.out.println("MINUTES：" + d4);
    System.out.println("SECONDS：" + d5);
    System.out.println("MILLIS：" + d6);
    System.out.println("NANOS：" + d7);

  }
}