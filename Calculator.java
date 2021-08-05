public class Calculator {
  public static void main(String[] args) {

    //Javaコマンドに(クラスを除き)引き渡した第１引数の値をint型に変換し、変数aに代入
    int a = Integer.parseInt(args[0]);
    String x = args[1];
    int b = Integer.parseInt(args[2]);

    if (args.length != 3){
      System.out.println("引数は3つにしてください");
    }

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
    }
  }
}
