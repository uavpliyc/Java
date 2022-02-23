public class GenericsClassMain {
  // 参照型のみ
  // 右のダイヤモンドは省略可
  GenericsClass<int[]> gc = new GenericsClass<>();

  // ジェネリックメソッド
  public static <T> T method(T t) {
    return t;
  };

}