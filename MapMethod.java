import java.util.HashMap;
import java.util.Map;

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
  }
}