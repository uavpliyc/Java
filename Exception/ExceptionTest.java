package Exception;
public class ExceptionTest {
  public static void main(String[] args) {
    Sample s = new Sample();
    try {
      s.runSample();
    } catch (ExceptionClass e) {
      // getMessageメソッド
      System.out.println(e.getMessage());
      System.out.println(e);
      System.out.println("ーーーーーースタックトレースここからーーーーーーー");
      // printStackTraceメソッド
      e.printStackTrace();
      System.out.println("ーーーーーースタックトレースここまでーーーーーーー");
    }
  }
}

class Sample {
  void runSample() throws ExceptionClass {
    int i = 5;
    if (i == 5) {
      // throwで作成した例外を投げる
      throw new ExceptionClass("独自の例外です");
    }
  }
}
