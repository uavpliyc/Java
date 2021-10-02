package Bank;
public class BankAccount {
  // //口座名義
  // private String myname;
  // //口座残高
	// private int balance;

	//初期値を入れるコンストラクタ
	public BankAccount(String myname, int balance){
		System.out.println("ーーーーーーーーーーーー");
		System.out.println("口座名義：" + myname);
		System.out.println("口座残高：" + balance + "円");
		System.out.println("ーーーーーーーーーーーー");
	}

}
