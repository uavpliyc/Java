public class ThreadClass {
  public static void main(String[] args) {

    // スレッド作成
    ThreadA a = new ThreadA();
    ThreadB b = new ThreadB();
    ThreadC c = new ThreadC();

    // スレッド実行開始
    a.start();
    b.start();
    Thread t = new Thread(c);
    t.start();
  }
}

// スレッドの出力は毎回変わる

// ①Threadを継承
class ThreadA extends Thread {
  // runメソッドをオーバーライド
  @Override
  public void run(){
    for (int i = 0; i < 10; i++){
      System.out.println("A:" + i + "");
    }
  }
}

class ThreadB extends Thread {
  public void run(){
    for (int i = 0; i < 10; i++){
      System.out.println("B:" + i + "");
    }
  }
}

class ThreadC implements Runnable {
  public void run(){
    for (int i = 0; i < 10; i++){
      System.out.println("C:" + i + "");
    }
  }
}