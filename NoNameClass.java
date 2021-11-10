interface MyInter {
  void method();
}

class Outer {
  void method(){
    // MyInterを実装した無名クラスをインスタンス化
    new MyInter(){
      public void method(){
        System.out.println("NoNameClassMethod!");
      }
    }.method();
  }
}

public class NoNameClass {
  public static void main(String[] args) {
    new Outer().method();
  }
}