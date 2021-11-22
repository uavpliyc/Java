import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StreamMethod {
  public static void main(String[] args) {
    List<String> data1 = Arrays.asList("a", "b", "c");
    // allMatchメソッド
    boolean result1 = data1.stream().allMatch(s -> s == "a");
    // anyMatchメソッド
    boolean result2 = data1.stream().anyMatch(s -> s == "a");
    // noneMatchメソッド
    boolean result3 = data1.stream().noneMatch(s -> s == "a");
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);

    data1.forEach(System.out::println);

    IntStream data2 = IntStream.of(10,20,30);
    /**
     * reduceメソッド
     * @param1 初期値
     * @param2 集約処理
     */
    int result4 = data2.reduce(0, (a,b) -> a + b);
    System.out.println(result4);

    // いろんなSystem
    Set<String> set = new HashSet<>();
    set.add("c");
    set.add("a");
    set.add("b");
    set.forEach(System.out::println);
    set.forEach(s -> System.out.println(s));
  }
}