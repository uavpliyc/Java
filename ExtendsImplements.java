public class ExtendsImplements extends ExtendsTest {
  public static void main(String[] args) {
    ExtendsImplements e = new ExtendsImplements();
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