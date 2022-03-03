import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    IntStream data2 = IntStream.of(1,2,3,4,5);
    /**
     * reduceメソッド
     * @param1 初期値
     * @param2 集約処理
     */
    int result4 = data2.reduce(0, (a,b) -> a + b);
    System.out.println(result4);

    // 上記と同じ
    System.out.println(IntStream.rangeClosed(1, 5).sum());

    // いろんなSystem
    Set<String> set = new HashSet<>();
    set.add("c");
    set.add("a");
    set.add("b");
    set.forEach(System.out::println);
    set.forEach(s -> System.out.println(s));

    List<Integer> a = Arrays.asList(1,2);
    List<Integer> b = Arrays.asList(3,4);
    List<List<Integer>> c = Arrays.asList(a, b);
    c.stream().flatMap(e -> e.stream())
    .map(e -> e + 1).forEach(System.out::println);

    String[] values = {"age", "name", "sample"};
    List<String> list = Arrays.asList(values);
    // Optional型を返す ×String型
    Optional<String> str = list.stream().filter(s -> s.length() > 3).findFirst();
    System.out.println(str);
    System.out.println(str.get());

    // range(終わり含まない)
    IntStream.range(1, 5).forEach(System.out::println);
    // rangeClosed(終わり含む)
    IntStream.rangeClosed(1, 5).forEach(System.out::println);

    // sortedメソッド(自然順)
    Arrays.asList(2,3,1).stream()
    .sorted()
    .forEach(System.out::println);

    Stream<String> stream = Stream.of("banana","apple","orange")
    .filter(e -> e.length() > 5)
    .peek(e -> System.out.println(e + " "))
    .map(String::toUpperCase)
    .peek(e -> System.out.println(e + " "));
    stream.forEach(System.out::println);

  }
}