import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(7,10,12,9,31);
    Predicate<Integer> p = n -> {
      int count = 0;
      boolean result = n > 10;
      System.out.println(count++ + ":");
      return result;
    };

    // filterの引数に渡す
    list.stream().filter(p).findFirst().ifPresent(System.out::println);
  }
}