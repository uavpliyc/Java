package Access;
public class Access {
  //private修飾子のインスタンス変数
  private int A;

  //public修飾子のコンストラクタ
  public Access(int B){
    A = B;
  }

  //アクセサメソッド
  public int getB(){
    return A;
  }
}


