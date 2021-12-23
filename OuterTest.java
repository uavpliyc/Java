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
}