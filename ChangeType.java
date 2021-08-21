public class ChangeType {
  public static void main(String[] args){
    int i = 10;
    method1(i);

    double d = method2();
    System.out.println(d);
  }
  
  public static void method1(double x){
    System.out.println(x);
  };

  public static int method2(){
    int i = 10;
    return i;
  }
}
