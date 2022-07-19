public class OuterTestMain2 {
  public static void main(String[] args) {

    // インターフェース.インナークラス.staticメソッド
    OuterTest2.Inner1.doIt();

    new OuterTest2(){
      public void doSomething(){
        class Inner2{
          public void execute(){
            System.out.println("doSomething");
          }
        }
        new Inner2().execute();
      }
    }.doSomething();

  }
}


interface OuterTest2{
  class Inner1{
    static void doIt(){
      System.out.println("doIt");
    }
  }
  void doSomething();
}