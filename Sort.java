import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    Comparator<Integer> obj = (v1, v2) -> v1 - v2;
    List<Integer> list = Arrays.asList(10,2,30,2);
    Collections.sort(list, obj);
    // binarySearch：配列から検索した要素のインデックスを返す(要sort)
    System.out.println(Collections.binarySearch(list, 2));
    System.out.println(Collections.binarySearch(list, 30));
    System.out.println(Collections.binarySearch(list, 100));
  }

}

