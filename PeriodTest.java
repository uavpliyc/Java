import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {
  public static void main(String[] args) {

    // Period：年月日
    Period p1 = Period.ofYears(3);
    System.out.println("ofYears：" + p1);

    Period p2 = Period.of(0, 10, 50);
    System.out.println("of：" + p2);

    // Duration：時分秒
    Duration d1 = Duration.ofDays(1);
    System.out.println("ofDays：" + d1);

    Duration d2 = Duration.of(1, ChronoUnit.SECONDS);
    System.out.println("of：" + d2);
    Duration d3 = Duration.of(1, ChronoUnit.MILLIS);
    System.out.println("of：" + d3);

  }
}