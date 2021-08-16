public class DepositMain {
  public static void main(String[] args) {
    int val1 = Integer.parseInt(args[0]);
    int val2 = Integer.parseInt(args[1]);
    Deposit depo = new Deposit();
    depo.setBalance(val1, val2);
    // System.out.println(depo.setBalanceOut(val1, val2));
    System.out.println(depo.getBalance());
    System.out.println(depo.getBankNum());
    // System.out.println(depo.getBankName());
  }
}
