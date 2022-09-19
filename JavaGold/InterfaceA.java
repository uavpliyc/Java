package JavaGold;

// 課題7-1：インターフェースを用いて入出力処理に規約を設ける
public interface InterfaceA {

  default void set(String input) {
    System.out.println(input);
  }

  default void execute() {
    System.out.println("入力がありません");
  }

}