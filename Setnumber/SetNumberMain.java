package Setnumber;

public class SetNumberMain {
  public static void main(String[] args) {
    //引数引き渡しているのでコンストラクタ①が呼び出される
    SetNumber numA = new SetNumber(1000);
    //引数引き渡していないのでコンストラクタ②が呼び出される
    SetNumber numB = new SetNumber();
    numA.getNumber();
    numB.getNumber();
  }
}
