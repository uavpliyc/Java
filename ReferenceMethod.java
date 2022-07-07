import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ReferenceMethod {
  public static void main(String[] args) {
    // staticメソッド参照：引数を省略可能
    Function<String, Integer> f1 = Integer::parseInt;
    int num = f1.apply("100");
    System.out.println(num);

    Comparator<Integer> comp = Integer::compare;
    System.out.println(comp.compare(1, 2));
    System.out.println(comp.compare(2, 2));
    System.out.println(comp.compare(2, 1));

    List<Integer> list = Arrays.asList(1,2,3);
    // インスタンスメソッド参照
    list.forEach(System.out::println);

    method(Foo::new);

  }
  static void method(Supplier<? extends Foo> foo){
    foo.get().doIt();
  }
}

class Foo{
  public void doIt(){
    System.out.println("DoIt");
  }
}