public class ForeignDeposit extends Deposit{

  //レート用メンバ変数の宣言
  private static int rate = 110;

  //コンストラクタ
  public ForeignDeposit(String number, String name, int balance){
    super(number, name, balance);
  }

  //自インスタンスの残高を日本円残高で返すゲッターメソッド
  public int getBalanceByYen(){
    return getBalance() * rate;
  }
}
