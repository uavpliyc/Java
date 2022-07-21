public class ExtendsImplements extends ExtendsTest {
  public static void main(String[] args) {
    ExtendsImplements e = new ExtendsImplements();
    // 同一メソッド名の場合、ImplementsよりExtendsが優先される
    e.test();
  }
}

class ExtendsTest {
  void test(){
    System.out.println("Extends");
  };
}

interface ImplementsTest {
  default void test(){
    System.out.println("Implements");
  };
}