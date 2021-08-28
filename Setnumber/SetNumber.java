package Setnumber;

public class SetNumber {
  private int num1;
  private int num2;

  //int型の引数を持つコンストラクタ①
  SetNumber (int i) {
    this.num1 = 100;
    this.num2 = i;
  }
  //引数を持たないコンストラクタ②
  SetNumber () {
    this(500);
    //this.num1 = 100;
    //this.num2 = 500;
  }

  public void getNumber(){
    System.out.println(num1);
    System.out.println(num2);
  }
}
