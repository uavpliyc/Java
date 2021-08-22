package Bank;
public class BankAccount {
  //口座名義
  private String myname;
  //口座残高
	private int balance;

	// 口座名義を参照
	public String getName() {
		return myname;
	}
	// 口座名義を更新
	public void setName(String sVal) {
		myname = sVal;
	}
	// 残高を参照
	public int getBalance() {
		return balance;
	}
	// 残高を更新
	public void setBalance(int val) {
		balance = val;
	}

  public void showAccount() {
		System.out.println("口座名義：" + myname);
		System.out.println("口座残高：" + balance + "円");
	}
}
