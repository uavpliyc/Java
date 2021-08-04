public class Calculator {
  public static void main(String[] args) {
    int a = 6;
    int b = 3;
    String x;
    
    a = Integer.parseInt(args[0]);
    x = args[1];
    b = Integer.parseInt(args[2]);

    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b);
    System.out.println(x);
  }
}
