public class Singleton {

  // 自身のインスタンス作成
  private static final Singleton singleton = new Singleton();

  // コンストラクタ(外部からインスタンス生成を防ぐ)
  private Singleton() {};

  // 自身のインスタンスの参照を返す
  public static Singleton getInstance() {
    return singleton;
  }

}