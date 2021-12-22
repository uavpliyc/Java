import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Format {
  public static void main(String[] args) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yy,MM,dd");
    String target = "21,12,22";
    LocalDate date = LocalDate.parse(target, fmt);
    System.out.println(date);
  }
}