public class Deposit {

  //口座番号の宣言
  private String number;
  //口座名の宣言
  private String name;
  //口座残高の宣言と初期化
  private int balance;

  //コンストラクタ
  public Deposit(String number, String name, int balance){
    this.number = number;
    this.name = name;
    this.balance = balance;
  }

  //入金処理
  public void inBalance(int val){
    balance += val;
  }
  //出金処理
  public void outBalance(int val){
    balance -= val;
  }
  //残高取得処理ゲッター
  public int getBalance(){
    return balance;
  }
  //口座番号取得処理ゲッター
  public String getNumber(){
    return number;
  }
  //口座名取得処理ゲッター
  public String getName(){
    return name;
  }

}
