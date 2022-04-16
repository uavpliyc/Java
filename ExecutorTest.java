import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
  public static void main(String[] args) {
    Runnable task = new MyTask();
    ExecutorService execute = Executors.newScheduledThreadPool(3);
    execute.execute(task);
    try {
      // 3秒たいき
      Thread.sleep(3000);
    } catch (InterruptedException e) {
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