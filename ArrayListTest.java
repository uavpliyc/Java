import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.UnaryOperator;

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

    // コピー
    List<Integer> list2 = new CopyOnWriteArrayList<>(list);

    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext())
      System.out.println(iter.next());

    Iterator<Integer> iter2 = list2.iterator();
    while(iter.hasNext())
      System.out.println(iter2.next());

    List<Integer> li = Arrays.asList(1,2,3);
    UnaryOperator<Integer> u = s -> s * 2;
    // replaceAll
    li.replaceAll(u);
    li.forEach(n -> System.out.println(n));

  }
}