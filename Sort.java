import java.util.Set;
import java.util.TreeSet;

public class Sort {
  public static void main(String[] args) {
    // 辞書順に並び替えられる
    Set<String> set = new TreeSet<>();
    set.add("C");
    set.add("B");
    set.add("A");
    set.add("D");
    System.out.println(set);
  }

}

