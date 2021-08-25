package Deposit;

public class DepositException extends Exception {
  //スタックトレースメッセージを初期化するコンストラクタ宣言
  //引数：自インスタンスのメッセージの初期値
  public DepositException(String msg){
    super(msg);
  }
}
