import java.util.List;
import java.util.Map;
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

  }
}