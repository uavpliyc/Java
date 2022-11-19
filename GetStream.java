import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GetStream {

    // Collection
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> listStream = list.stream();

    // Arrays
    String[] s = {"a", "b", "c"};
    Stream<String> arryaysStream = Arrays.stream(s);

    // Stream
    Stream<String> stream = Stream.of("a", "b", "c");    

    // IntStream
    IntStream intStream = IntStream.range(1, 5);

}
