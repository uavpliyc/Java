import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ChangeStream {
  Stream<List<String>> s1 = Stream.of(Arrays.asList("1", "a"), Arrays.asList("2", "b"));

  // Stream → Stream
  Stream<String> s2 = s1.flatMap(x -> x.stream());
}