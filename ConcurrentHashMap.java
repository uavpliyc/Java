import java.util.Map;

public class ConcurrentHashMap {
    public static void main(String[] args) {
        // Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new java.util.concurrent.ConcurrentHashMap<>();

        map.put(1, "A");
        map.put(2, "B");

        for(Integer key : map.keySet()) {
            map.remove(key);
        }
    }
}
