public class DepositMain {
  public static void main(String[] args) {

    // 銀行のアドレス値を要素として持つ配列の生成
    Deposit[] depts = new Deposit[] { new Deposit("0001", "太郎銀行口座", 10000), new Deposit("0002", "次郎銀行口座", 10000),
        new Deposit("0003", "三郎銀行口座", 10000) };

    // 外貨銀行のアドレス値を要素として持つ配列の生成
    ForeignDeposit[] fdepts = new ForeignDeposit[] { new ForeignDeposit("0001", "taro銀行口座", 100),
        new ForeignDeposit("0002", "jiro銀行口座", 100), new ForeignDeposit("0003", "saburo銀行口座", 100) };

    // 銀行口座の数分ループする
    for (int i = 0; i < depts.length; i++) {
      // ループ回数に応じて当該銀行口座のアドレス値を代入する変数宣言
      Deposit dept = depts[i];
      int val = Integer.parseInt(args[i]);
      switch (args[depts.length]) {
        case "IN":
          dept.inBalance(val);
          break;
        case "OUT":
          dept.outBalance(val);
          break;
      }
      System.out.println("口座名：" + dept.getName() + "（口座番号：" + dept.getNumber() + "） 残高：" + dept.getBalance() + "円");
    }

    // 銀行口座の数分ループする
    for (int i = 0; i < fdepts.length; i++) {
      // ループ回数に応じて当該銀行口座のアドレス値を代入する変数宣言
      ForeignDeposit fdept = fdepts[i];
      int val = Integer.parseInt(args[i]);
      switch (args[depts.length]) {
        case "IN":
          fdept.inBalance(val);
          break;
        case "OUT":
          fdept.outBalance(val);
          break;
      }
      System.out.println("外貨口座名：" + fdept.getName() + "（口座番号：" + fdept.getNumber() + "） 残高：" + fdept.getBalance() + "ドル("
          + fdept.getBalanceByYen() + "円)");
    }
  }
}
