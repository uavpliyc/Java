import java.time.Period;

public class PeriodTest {
  public static void main(String[] args) {

    Period p1 = Period.ofYears(3);
    System.out.println("ofYears：" + p1);

    Period p2 = Period.of(0, 10, 50);
    System.out.println("of：" + p2);

  }
}