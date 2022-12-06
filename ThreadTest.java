public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread : sleep開始");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("thread : 割り込みキャッチ");
            }
            System.out.println("thread : 処理再開");
        });

        thread.start();

        try {
            System.out.println("main : sleep開始");
            Thread.sleep(2000);
            System.out.println("main : sleep終了");
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main : 割り込みキャッチ");
        }
    }
}
