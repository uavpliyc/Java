import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
  public static void main(String[] args) {

    CyclicBarrier barrier = new CyclicBarrier(3);

    Runnable r = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName + ": start");
      try {
        Thread.sleep((int)(Math.random() * 5000));
        System.out.println(threadName + ": waiting...");
        barrier.await();
        boolean b = barrier.isBroken();
        System.out.println("barrier : " + b);
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
      System.out.println(threadName + ": end");
    };

    new Thread(r).start();
    new Thread(r).start();
    new Thread(r).start();

  }
}