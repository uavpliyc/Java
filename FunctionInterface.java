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
  public static void main(String[] args) {
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
    BiFunction<Integer,Integer,Integer> bifunc = (a,b) -> a * b;
    System.out.println(bifunc.apply(10, 10));

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
    BiConsumer<Integer,Integer> bicon = (a,b) -> System.out.println("BiConsumer");
    bicon.accept(10, 100);

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

    // 異なる型を引数に、基本データ型を返す関数型インターフェース
    ToIntFunction<String> obj1 = (String s) -> {return s.length();};
    System.out.println(obj1.applyAsInt("value"));
  }
}