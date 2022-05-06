import java.util.Optional;

public class OptionalTest {
  public static void main(String[] args) {

    Optional<Integer> op1 = Optional.of(10);
    Optional<Integer> op2 = Optional.empty();

    System.out.println("op1.get():" + op1.get());
    // emptyなら表示なし
    op2.ifPresent(System.out::println);

  }
}