package ChangeType;
public class ChangeType {
  public static void main(String[] args){

    int x = 10;
    short y = (short)x;
    System.out.println(y);

    //キャスト
    double a = 10.5;
    int b = (int)a;
    System.out.println(b);

    double i = 10.5;
    method1((int)i);

    int d = method2();
    System.out.println(d);
  }

  public static void method1(int x){
    System.out.println(x);
  }
  
  public static int method2(){
    double i = 10.5;
    return (int)i;
  }
}
