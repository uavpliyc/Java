import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
  public static void main(String[] args) {
    Runnable task = new MyTask();
    ExecutorService execute = Executors.newScheduledThreadPool(3);
    execute.execute(task);
    try {
      // 3秒たいき
      Thread.sleep(3000);
      Future<Date> result = execute.submit(() -> new java.util.Date());
      System.out.println(result.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    execute.execute(task);
    // タスクの終了
    execute.shutdown();
  }
}

class MyTask implements Runnable {
  public void run() {
    System.out.println("OK");
  }
}