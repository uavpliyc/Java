package JavaGold;

import java.util.Collection;

// 課題7-1：インターフェースを用いて入出力処理に規約を設ける
public interface InterfaceB extends InterfaceA {

  default void set(Collection<String> input) {
    input.forEach(System.out::println);
  }

  // 入力済み情報の確認
  void display();

  // 入力済み情報の初期化
  void clear();

}