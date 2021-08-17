public class DepositMain {
  public static void main(String[] args) {
    Deposit taro = new Deposit("0001", "太郎銀行口座", 10000);
    Deposit jiro = new Deposit("0002", "次郎銀行口座", 10000);
    int val1 = Integer.parseInt(args[0]);
    int val2 = Integer.parseInt(args[1]);
    switch (args[2]) {
      case "IN":
        taro.inBalance(val1);
        jiro.inBalance(val2);
        break;
      case "OUT":
        taro.outBalance(val1);
        jiro.outBalance(val2);
        break;
    }
    System.out.println("口座名：" + taro.getBankName() + "（口座番号：" + taro.getBankNum() + "） 残高：" + taro.getBalance());
    System.out.println("口座名：" + jiro.getBankName() + "（口座番号：" + jiro.getBankNum() + "） 残高：" + jiro.getBalance());
  }
}
