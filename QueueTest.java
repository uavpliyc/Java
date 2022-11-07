import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
  public static void main(String[] args) {
    Queue<String> q = new ArrayDeque<>();
    // add
    q.add("test");
    q.add("test2");
    q.add("test3");
    System.out.println(q);
    // peek：最初の要素を取得
    System.out.println(q.peek());
    // pool：最初の要素を削除して取得
    System.out.println(q.poll());
    // remove：最初の要素を削除して取得
    System.out.println(q.remove());
    // element：最初の要素を取得
    System.out.println(q.element());

    q.clear();
    System.out.println(q);

  }
}