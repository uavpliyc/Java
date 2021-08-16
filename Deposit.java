public class Deposit {

  //口座番号の宣言
  private int bankNum;

  //口座名の宣言
  private String bankName = "銀行";

  //口座残高の宣言と初期化
  private int balance = 10000;


  //コンストラクタ
  public Deposit(){
    
  }

/*
  public Deposit(int val1, int val2, String symbol){
    switch (symbol) {
      case "IN":
        money1 += val1;
        money2 += val2;
        break;
      case "OUT":
        money1 -= val1;
        money2 -= val2;
        break;
    }
  }
*/
  //入金処理セッター
  public void setBalance(int val1, int val2){
    balance += val1;
  }

  //出金処理セッター
  public void setBalanceOut(int val1, int val2){
    balance -= val1;
  }

  //残高取得処理ゲッター
  public int getBalance(){
    return balance;
  }
  //口座番号取得処理ゲッター
  public int getBankNum(){
    return bankNum;
  }
  //口座名取得処理ゲッター
  // public string getBankName(){
  //   return bankName;
  // }

}
