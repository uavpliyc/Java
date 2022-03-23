import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoin {
  public static void main(String[] args) {
    Double[] nums = new Double[10];
    ForkJoinTask<?> task = new ExamRecursiveAction("main", nums, 0, 10);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(task);
  }
}

class ExamRecursiveAction extends RecursiveAction {
  private Double[] nums;
  private int start;
  private int end;

  // コンストラクタ
  public ExamRecursiveAction(String name, Double[] nums, int start, int end) {
    System.out.println("name " + name + " " + start + " " + end);
    this.nums = nums;
    this.start = start;
    this.end = end;
  }

  // computeメソッド実装
  protected void compute() {
    if(end - start <= 3) {
      for(int i = start; i < end; i++) {
        nums[i] = Math.random() * 100;
        System.out.println("nums[" + i + "]" + nums[i]);
      }
    } else {
      int middle = start + (end - start)/2;
      System.out.println("start: " + start + "middle: " + middle + "end: " + end);
      // invokeAllメソッド
      invokeAll(new ExamRecursiveAction("f1", nums, start, middle));
      invokeAll(new ExamRecursiveAction("f2", nums, middle, end));
    }

  }
}