import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class InstantTest {
  public static void main(String[] args) {

    // 1970-01-01 00:00:00
    System.out.println(Instant.EPOCH);

    System.out.println("now:" + Instant.now());

    System.out.println(Instant.now().toEpochMilli());

    System.out.println("ofEpochMilli(1000):" + Instant.ofEpochMilli(1000));
    System.out.println("ofEpochSecond(2000):" + Instant.ofEpochSecond(2000));
    System.out.println("ofEpochSecond(3000, 10):" + Instant.ofEpochSecond(3000, 10));

    // ZoneDateTime,OffsetDateTimeなら引数不要、LocalDateTimeならZoneOffset引数が必要
    System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+09:00")));
    System.out.println(ZonedDateTime.now().toInstant());
    System.out.println(OffsetDateTime.now().toInstant());

    System.out.println(Instant.ofEpochSecond(0));
  }
}