public class Deposit {

  //口座番号の宣言
  private String bankNum;
  //口座名の宣言
  private String bankName;
  //口座残高の宣言と初期化
  private int balance;

  //コンストラクタ
  public Deposit(String num, String name, int iBalance){
    bankNum = num;
    bankName = name;
    balance = iBalance;
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
  public String getBankNum(){
    return bankNum;
  }
  //口座名取得処理ゲッター
  public String getBankName(){
    return bankName;
  }

}
