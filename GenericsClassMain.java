public class GenericsClassMain {
  // 参照型のみ
  // 右のダイヤモンドは省略可
  GenericsClass<int[]> gc = new GenericsClass<>();

  // ジェネリックメソッド
  public static <T> T method(T t) {
    return t;
  };

  // メソッド内でのジェネリクス(String型を子に持つ引数のみ)
  void method2(GenericsClass<? super String> obj) {}

}