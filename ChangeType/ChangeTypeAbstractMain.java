package ChangeType;
public class ChangeTypeAbstractMain {
  public static void main(String[] args){
    ChangeTypeAbstract ctr = new ChangeTypeRefer();
    //キャスト
    ChangeTypeRefer sub = (ChangeTypeRefer)ctr;
    sub.method1();
    sub.method2();
  }
}
