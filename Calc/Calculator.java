package Calc;

public class Calculator {
  public static void main(String[] args) {

    try{
      int a = Integer.parseInt(args[0]);
      String x = args[1];
      int b = Integer.parseInt(args[2]);

      switch(x){
      case "p":
        System.out.println(a + b);
        break;
      case "mi":
        System.out.println(a - b);
        break;
      case "mu":
        System.out.println(a * b);
        break;
      case "d":
        System.out.println(a / b);
        break;
      case "%":
        System.out.println(a % b);
        break;
      }
    }
    catch(NumberFormatException e){
      System.out.println("第１引数第３引数には数値を入力してください");
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("引数は3つにしてください");
    }
  }
}
