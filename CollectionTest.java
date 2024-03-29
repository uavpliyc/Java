import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTest {
  public static void main(String[] args) {
    
    Stream<String> st = Stream.of("berry", "apple", "melon", "orange", "applejuice");
    // groupingBy
    Map<String, List<String>> map = st.collect(Collectors.groupingBy(s -> s.substring(0, 1)));
    System.out.println(map);

    Stream<Integer> st2 = Stream.of(3,5,7,9);
    // partitioningBy
    Map<Boolean, List<Integer>> map2 = st2.collect(Collectors.partitioningBy(s -> s > 5));
    System.out.println(map2);

    Stream<Integer> st3 = Stream.of(1,5,2,9);
    // toSet
    System.out.println(st3.collect(Collectors.toSet()));

    Stream<String> st4 = Stream.of("apple","melon","rice");
    // toMap
    System.out.println(st4.collect(Collectors.toMap(Function.identity(), String::valueOf)));

    Stream<String> st5 = Stream.of("apple","melon","rice");
    // summingInt
    System.out.println(st5.collect(Collectors.summingInt(t -> t.length())));

    Stream<Integer> st6 = Stream.of(3,24,6);
    // averagingInt
    System.out.println(st6.collect(Collectors.averagingInt(t -> t)));

    List<Integer> array = Arrays.asList(4,6,2,64,1,44);
    
    // binarySearch(ソートせずにそのままだと誤った結果返す)
    System.out.println("ソート前：" + Collections.binarySearch(array, 64));
    Collections.sort(array);
    System.out.println("ソート後：" + Collections.binarySearch(array, 64));

  }
}