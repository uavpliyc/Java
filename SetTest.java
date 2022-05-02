import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
  public static void main(String[] args) {

    // HashSet
    HashSet<Number> set = new HashSet<>();
    set.add(100);
    set.add(1);
    set.add(100);
    set.add(null);
    System.out.println(set);

    // TreeSet
    TreeSet<String> set1 = new TreeSet<>();
    set1.add("apple");
    set1.add("melon");
    set1.add("strawberry");
    // ceiling：引数と等しいかそれより大きいものの中で最小の値を返す
    System.out.println(set1.ceiling("a"));
    // floor：引数と等しいかそれより小さいものの中で最大の値を返す
    System.out.println(set1.floor("b"));

    // Iteratorを使って要素取得
    Iterator<String> iter = set1.iterator();
    while(iter.hasNext()){
      System.out.println(iter.next());
    };

  }
}