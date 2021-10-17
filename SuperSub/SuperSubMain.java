package SuperSub;

public class SuperSubMain {
  public static void main(String[] args){
    SubClass sub = new SubClass();
    sub.getVal();
    //型を持っているか判定
    System.out.println(sub instanceof SuperClass);
  }
}
