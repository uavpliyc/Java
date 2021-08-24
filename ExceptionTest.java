public class ExceptionTest {
  public static void main(String[] args) {
    Sample s = new Sample();

    try {
      s.runSample();

      // 独自の例外をキャッチ
    } catch (ExceptionClass e) {
      System.out.println(e.getMessage());// 独自の例外です
      System.out.println(e);// test1.MyTest1Exception: 独自の例外です
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
