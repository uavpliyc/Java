import java.util.Random;
import java.util.Scanner;

public class JavaMethod {
  public static void main(String[] args){
    // 乱数
    int r = new Random().nextInt(100);
    // キーボード入力
    String s = new Scanner(System.in).nextLine();
    int i = new Scanner(System.in).nextInt();
    System.out.println("あなたの名前は" + s + "。年齢は" + i + "。レベルは" + r);
  }
}