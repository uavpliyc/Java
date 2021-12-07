import java.util.Arrays;

public class ParallelStream {
  public static void main(String[] args) {
    Arrays.asList("one", "two", "three")
      .parallelStream()
      .map(
        s -> { System.out.println(s + "");
          return s.toUpperCase();
        }
      )
      .forEach(s -> System.out.println(s + ""));
  }
}