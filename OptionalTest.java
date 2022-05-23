import java.util.Optional;

public class OptionalTest {
  public static void main(String[] args) {

    Optional<Integer> op1 = Optional.of(10);
    Optional<Integer> op2 = Optional.empty();
    Optional<String> op3 = Optional.ofNullable("null");

    System.out.println("op1.get():" + op1.get());
    // emptyなら表示なし
    op2.ifPresent(System.out::println);
    System.out.println("op3.get():" + op3.get());

    // isPresent
    System.out.println("op3.isPresent():" + op3.isPresent());

  }
}