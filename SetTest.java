import java.util.TreeSet;

public class SetTest {
  public static void main(String[] args) {
    TreeSet<String> set1 = new TreeSet<>();
    set1.add("apple");
    set1.add("melon");
    set1.add("strawberry");
    // ceiling
    System.out.println(set1.ceiling("a"));
  }
}