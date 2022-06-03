import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atomic {
  public static void main(String[] args) {
    AtomicInteger num1 = new AtomicInteger(0);
    // int[] num2 = {0};
    IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> num1.incrementAndGet());
    System.out.println(num1);
    
    AtomicInteger num2 = new AtomicInteger(0);
    IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> num2.getAndIncrement());
    System.out.println(num2);
    
  }
}
