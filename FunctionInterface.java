import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class FunctionInterface {

  // 独自の関数型インターフェース
  @FunctionalInterface
  public interface Foo {
    // 抽象メソッド1つ
    void x();
  }

  @FunctionalInterface
  public interface CalcFunction<T,U> {
    public double calculate(T num1, U num2);
  }

  public static void main(String[] args) {

    CalcFunction<Integer, Double> calc = (a,b) -> a * b;
    System.out.println(calc.calculate(3, 2.5));

    /**
     * Functionインターフェース
     * @param T
     * @return R
    */
    Function<Integer,Integer> func = a -> a * 100;
    System.out.println(func.apply(10));

    /**
     * BiFunctionインターフェース
     * @param T,U
     * @return R
     */
    BiFunction<Integer,Integer,Integer> biFunc = (a,b) -> a * b;
    System.out.println(biFunc.apply(10, 10));

    /**
     * Consumerインターフェース
     * @param T
     */
    Consumer<Integer> con = a -> System.out.println("consumer");
    con.accept(100);

    /**
     * BiConsumerインターフェース
     * @param T,U
     */
    BiConsumer<Integer,Integer> biCon = (a,b) -> System.out.println("BiConsumer");
    biCon.accept(10, 100);

    /**
     * Predicateインターフェース
     * @param T
     * @return boolean
     */
    Predicate<Integer> pre = a -> a > 10;
    System.out.println(pre.test(20));

    /**
     * Supplierインターフェース
     * @return T
     */
    Supplier<Integer> sup = () -> 11;
    System.out.println(sup.get());

    /**
     * BiFunctionインターフェース
     */
    IntFunction<String[]> obj = String[]::new;
    System.out.println(obj.apply(10).length);

    /**
     * UnaryOperatorインターフェース
     * @param T
     * @return T
     */
    UnaryOperator<Integer> unary = a -> a * 120;
    System.out.println(unary.apply(10));

    // 基本データ型を扱う関数型インターフェース
    IntFunction<String[]> obj3 = String[]::new;
    System.out.println(obj3.apply(5).length);

    // 異なる型を引数に、基本データ型を返す関数型インターフェース
    ToIntFunction<String> obj1 = (String s) -> {return s.length();};
    System.out.println(obj1.applyAsInt("value"));

    // コンストラクタ参照
    String str = "test";
    Function<String,Integer> f = str::indexOf;
    Integer i = f.apply("aaa");
    System.out.println(i);
  }
}