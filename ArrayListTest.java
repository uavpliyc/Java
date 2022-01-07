import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
  public static void main(final String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    System.out.println(list);
    System.out.println(list.size());
    System.out.println(list.get(1));

    list.add(0, 10);
    System.out.println(list);

    System.out.println(list.contains(1));
    System.out.println(list.contains(5));

    // forEach
    list.forEach(item -> System.out.println(item));

    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext())
      System.out.println(iter.next());
  }
}