import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("a","b","c");
        System.out.println(s.collect(Collectors.joining("/")));
        
        Stream<String> s1 = Stream.of("bronze","silver","gold","sample","goal");
        Map<String, List<String>> map1 = s1.collect(Collectors.groupingBy(i -> i.substring(0, 1)));
        System.out.println(map1);

        Stream<Integer> s2 = Stream.of(1,5,10,20);
        Map<Boolean, List<Integer>> map2 = s2.collect(Collectors.partitioningBy(a -> a > 9));
        System.out.println(map2);

    }
}
