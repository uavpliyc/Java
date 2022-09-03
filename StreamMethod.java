import java.util.Arrays;
import java.util.Comparator;
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

    c.stream().flatMap(e -> e.stream()).forEach(s -> System.out.println(s + " "));

    String[] values = {"age", "name", "sample"};
    List<String> list = Arrays.asList(values);
    // findFirstメソッド：Optional型を返す ※String型ではない
    Optional<String> str = list.stream().filter(s -> s.length() > 3).findFirst();
    System.out.println(str);
    System.out.println(str.get());

    // range(終わり含まない)
    IntStream.range(1, 5).forEach(System.out::println);
    // rangeClosed(終わり含む)
    IntStream.rangeClosed(1, 5).forEach(System.out::println);

    // IntStreamのリダクションメソッド：データ集合を1つに要約する終端操作
    // count
    System.out.println("count: " + IntStream.of(1,2,3).count());
    // sum
    System.out.println("sum: " + IntStream.of(1,2,3).sum());
    // average
    System.out.println("average: " + IntStream.of(1,2,3).average());
    System.out.println("average: " + IntStream.of(1,2,3).average().getAsDouble());

    // sortedメソッド(自然順)
    Arrays.asList(2,3,1).stream()
    .sorted()
    .forEach(System.out::println);
    // sortedメソッド(逆順)
    Arrays.asList(2,3,1).stream()
    .sorted((i,j) -> j - i)
    .forEach(System.out::println);

    Stream<String> stream = Stream.of("banana","apple","orange")
    .filter(e -> e.length() > 5)
    .peek(e -> System.out.println(e + " "))
    .map(String::toUpperCase)
    .peek(e -> System.out.println(e + " "));
    stream.forEach(System.out::println);

    Stream<List<String>> s1 = Stream.of(Arrays.asList("1", "Bill"), Arrays.asList("2", null));
    Stream<String> s2 = s1.flatMap((x) -> x.stream());
    s2.forEach(System.out::println);

    // minメソッド
    Stream<Integer> s = Arrays.asList(7,3,8).stream();
    System.out.println("min:" + s.min(Comparator.comparing(n -> n)).get());
    // maxメソッド
    Stream<Integer> ss = Arrays.asList(7,3,8).stream();
    System.out.println("max:" + ss.max(Comparator.comparing(n -> n)).get());

    Stream<String> stream10 = Arrays.asList("orange", "apple", "banana").stream()
        .filter(e -> e.length() < 6)
        .map(String::toUpperCase)
        .peek(System.out::println);
    System.out.print(stream10.findFirst().get());

    // sequential
    Arrays.asList("a","b","c").parallelStream()
    .map(String::toUpperCase)
    .sequential()
    .forEach(System.out::println);

    Stream.generate(() -> 0)
    .limit(3)
    .forEach(System.out::println);

  }
}