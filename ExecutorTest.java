import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorTest {
  public static void main(String[] args) {
    Runnable task = new MyTask();
    Executor execute = Executors.newScheduledThreadPool(3);
    execute.execute(task);
  }
}

class MyTask implements Runnable {
  public void run() {
    System.out.println("OK");
  }
}