import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
  public static void main(String[] args) {
    Queue<String> q = new ArrayDeque<>();
    // add
    q.add("test");
    q.add("test2");
    System.out.println(q);
    // peek：最初の要素を取得
    System.out.println(q.peek());

  }
}