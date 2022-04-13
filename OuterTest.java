public class OuterTest {

  public static void execute() {
    OuterTest.Inner inner = new OuterTest().new Inner();
    inner.doIt();
  }

  public class Inner {
    public void doIt() {
      System.out.println("JavaGold");
    }
  }

  private int num = 100;

  public void show() {
    String str = "num:";
    class Inner2 {
      private int num = OuterTest.this.num;
      public void show() {
        num += 100;
        System.out.println(str + num);
      }
    }
    new Inner2().show();
  }

}