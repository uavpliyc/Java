import java.util.ArrayList;
import java.util.List;

public class GenericsClassMain {

  // 参照型のみ
  // 右のダイヤモンドは省略可
  GenericsClass<int[]> gc = new GenericsClass<>();

  // ジェネリックメソッド
  public static <T> T method(T t) {
    return t;
  };

  // メソッド内でのジェネリクス(String型を子に持つ引数のみ)
  void method2(GenericsClass<? super String> obj) {}

  GenericsClass<Integer> gc2 = new GenericsClass<>();
  public GenericsClass<Integer> getGc2() {
    return gc2;
  }

  public static void main(String[] args) {
    List<A> list1 = new ArrayList<>();
    list1.add(new A());
    // List<? extends B> list2 = new ArrayList<>();
    // list2.add(new A());
    // TODO：逆じゃない？
    List<? super A> list3 = new ArrayList<>();
    list3.add(new B());
  }
}

class A {
  public String method() {
    return "A";
  }
}

class B extends A {
  public String method() {
    return "B";
  }
}