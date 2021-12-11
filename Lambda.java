import java.util.Comparator;

public class Lambda {
  public static void main(String[] args) {

    // 左より右大きい→負
    Comparator<Integer> c = (s1, s2) -> s1.compareTo(s2);
    System.out.println(c.compare(1, 2));

  }
}