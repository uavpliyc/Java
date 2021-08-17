public class DepositMain {
  public static void main(String[] args) {

    // 銀行のアドレス値を要素として持つ配列の生成
    Deposit[] depts = new Deposit[] {
       new Deposit("0001", "太郎銀行口座", 10000),
       new Deposit("0002", "次郎銀行口座", 10000),
       new Deposit("0003", "三郎銀行口座", 10000)
      };

      ForeignDeposit fodep = new ForeignDeposit();

    // 銀行口座の数分ループする
    for (int i = 0; i < depts.length; i++) {
      //ループ回数に応じて当該銀行口座のアドレス値を代入する変数宣言
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
      
      float rate = 1.1F;

      System.out.println("口座名：" + dept.getName() + "（口座番号：" + dept.getNumber() + "） 残高：" + dept.getBalance() + "円");
      System.out.println("口座名：" + fodep.getName() + "（口座番号：" + fodep.getNumber() + "） 残高：" + fodep.getBalance() * rate + "円");
    }
  }
}
