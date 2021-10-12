package SuperSub;

public class SuperSubMain {
  public static void main(String[] args){
    SubClass sub = new SubClass();
    sub.getVal();
    System.out.println(sub instanceof SuperClass);
  }
}
