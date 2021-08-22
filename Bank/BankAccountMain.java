package Bank;
public class BankAccountMain {
  public static void main(String[] args) {
		BankAccount acc = new BankAccount();

		acc.setName("田中太郎");
		acc.setBalance(1000000);
		acc.showAccount();
	}
}
