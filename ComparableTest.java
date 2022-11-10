import java.util.Map;
import java.util.TreeMap;

public class ComparableTest {
  public static void main(String[] args) {

    Map<ComparableObj, String> map = new TreeMap<>();

    map.put(new ComparableObj(1), "Gold");
    map.put(new ComparableObj(3), "Bronze");
    map.put(new ComparableObj(2), "Silver");

    for(ComparableObj c : map.keySet()) {
      System.out.println(c + ":" + map.get(c));
    }

  }
}

// Treeに入れるため、Comparableを実装
class ComparableObj implements Comparable<ComparableObj> {

  private int rank;

  public ComparableObj(int rank) {
    this.rank = rank;
  }

  @Override
  public String toString() {
    return String.valueOf(this.rank);
  }

  @Override
  public int compareTo(ComparableObj c) {
    return this.rank - c.rank;
  }
}