public class ThreadControl {
  public static void main(String[] args) {
    Share share = new Share();
    Thread1 thread1 = new Thread1(share);
    Thread2 thread2 = new Thread2(share);
    thread1.start();
    thread2.start();
  }
}

// 共有
class Share {
  private int a = 0;
  private String b;
  public void set(){
    a++;
    b = "data";
    System.out.println("set a:" + a + "b: " + b);
  }
  public void print(){
    a--;
    b = null;
    System.out.println("print a:" + a + "b: " + b);
  }
}

class Thread1 extends Thread {
  private Share share;
  public Thread1(Share share){
    this.share = share;
  }
  public void run(){
    for(int i =0; i < 5; i++){
      share.set();
    }
  }
}

class Thread2 extends Thread {
  private Share share;
  public Thread2(Share share){
    this.share = share;
  }
  public void run(){
    for(int i =0; i < 5; i++){
      share.print();
    }
  }
}