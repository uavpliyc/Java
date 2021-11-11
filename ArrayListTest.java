import java.util.ArrayList;

public class ArrayListTest {
  public static void main(final String[] args) {
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    System.out.println(list);
    System.out.println(list.size());
    System.out.println(list.get(1));

  }
}