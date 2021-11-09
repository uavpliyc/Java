package Abstract;
interface Interface {
  public static final int x = 10;
  public abstract void method();
  default void foo(){
    System.out.println("defaultMethod!");
  }
}
