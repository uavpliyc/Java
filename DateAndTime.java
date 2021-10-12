import java.time.LocalDate;

public class DateAndTime {
  public static void main(String[] args) {
    //コンストラクタがprivateなのでインスタンス生成はできない
    LocalDate now = LocalDate.now();
    System.out.println(now);
  }
}