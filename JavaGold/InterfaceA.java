package JavaGold;

public interface InterfaceA {

  default void set(String input) {
    System.out.println(input);
  }

  default void execute() {
    System.out.println("入力がありません");
  }

}