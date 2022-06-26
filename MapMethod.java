import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMethod {
  public static void main(String[] args) {
    Map<String, String> map1 = new HashMap<>();
    // put
    map1.put("A", "B");

    /** mergeメソッド
     * @param1:結合元キー
     * @param2:結合する文字列
     * @param3:結合方法
     */
    map1.merge("A", "C", (v1,v2) -> v1.concat(v2));
    map1.merge("B", "C", (v1,v2) -> v1.concat(v2));
    System.out.println(map1);

    // containsKey
    System.out.println(map1.containsKey("A"));
    // containsValue
    System.out.println(map1.containsValue("A"));
    System.out.println(map1.containsValue("C"));

    Map<Integer, String> map2 = new HashMap<>();
    map2.put(1, "first");
    map2.put(2, "second");
    map2.put(3, "third");

    // Map.Entryインターフェース
    for(Map.Entry<Integer, String> entry : map2.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    // キーと値を結合して出力
    map2.forEach((k, v) -> System.out.println(k + v));

    // TreeMap(自然順で並び替えてくれる)
    Map<Integer, String> items = new TreeMap<>();
    items.put(11, "String");
    items.put(90, "String");
    items.put(32, "value");
    System.out.println(items);


  }
}