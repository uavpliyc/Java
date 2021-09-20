package Exception;
public class Sample {
  public static void main(String[] args) {

    //Curryクラスのインスタンス化
    Curry curry = new Curry();

    //Curryクラスのフィールドの値を参照
    // String name = curry.name;
    System.out.println(curry.name);

    //Curryクラスのメソッドの実行
    System.out.println(curry.taste());

    CheeseCurry cheeseCurry = new CheeseCurry();

    System.out.println(cheeseCurry.newname);
   
    System.out.println(cheeseCurry.newtaste());

  }
}