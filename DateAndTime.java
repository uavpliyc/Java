import java.time.LocalDate;
import java.util.Date;

public class DateAndTime {
  public static void main(String[] args) {
    //コンストラクタがprivateなのでインスタンス生成はできない
    LocalDate now = LocalDate.now();
    System.out.println(now);
    LocalDate ofDate = LocalDate.of(2021, 10, 19);
    System.out.println(ofDate);

    Date d = new Date();
    System.out.println(d);
  }
}