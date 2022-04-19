import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantTest {
  public static void main(String[] args) {

    // 1970-01-01 00:00:00
    System.out.println(Instant.EPOCH);

    System.out.println(Instant.now());
    
    System.out.println(Instant.now().toEpochMilli());

    System.out.println(ZonedDateTime.now().toInstant());

    System.out.println(Instant.ofEpochSecond(0));
  }
}