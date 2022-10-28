public class Singleton {

  // ①自身のインスタンス作成(private static final)
  private static final Singleton singleton = new Singleton();

  // ②コンストラクタ(privateで外部からインスタンス生成を防ぐ)
  private Singleton() {};

  // ③自身のインスタンスの参照を返す
  public static Singleton getInstance() {
    return singleton;
  }

}