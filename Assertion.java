public class Assertion {
  public static void main(String[] args) {
    int price = Integer.parseInt(args[0]);
    // 実行時は「java -ea」使用
    assert (price > 0) : ("priceは0より大きくしてください");
    // ()なしでも可能
    assert price > 0;
    // 最初のアサーションでストップした場合はここまで辿り着かない
    assert false : ("false");
  }
}