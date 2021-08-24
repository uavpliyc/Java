public class ExceptionClass extends Exception {
  // warningを回避するための宣言
  private static final long serialVersionUID = 1L;

  // コンストラクタ
  ExceptionClass(String msg) {
    super(msg);
  }
}
