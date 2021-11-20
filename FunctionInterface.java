import java.util.function.IntFunction;

public class FunctionInterface {
  public static void main(String[] args) {
    // 引数や戻り値にint型を使用する関数型インターフェース
    IntFunction<String[]> obj = String[]::new;
    System.out.println(obj.apply(10).length);
  }
}