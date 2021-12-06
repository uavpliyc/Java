import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class ScheduledExecutorServiceInterface {
  public static void main(String[] args) {
    ScheduledExecutorService service = null;
    try {
      service = Executors.newSingleThreadScheduledExecutor();
      Runnable task1 = () -> System.out.println("task1");
      Callable<Date> task2 = () -> new Date();

      ScheduledFuture<?> result1 = service.schedule(task1, 3, TimeUnit.SECONDS);
      ScheduledFuture<Date> result2 = service.schedule(task2, 1, TimeUnit.MILLISECONDS);
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }
}