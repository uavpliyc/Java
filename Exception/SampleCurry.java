package Exception;

public class SampleCurry {
  public static void main(String[] args) {

    //Curryクラスのインスタンス化
    Curry curry = new Curry();

    //Curryクラスのフィールドの値を参照
    System.out.println(curry.name);
    System.out.println(curry.taste());

    CheeseCurry cheeseCurry = new CheeseCurry();

    System.out.println(cheeseCurry.newname);
    System.out.println(cheeseCurry.newtaste());

  }
}