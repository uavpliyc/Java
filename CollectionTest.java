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

  }
}