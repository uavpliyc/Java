package Calc;
public class CalcMain {
  public static void main(String[] args){
    // Calc calc = new Calc();
    try {
      int result = Calc.Calculate(Integer.parseInt(args[0]), args[1], Integer.parseInt(args[2]));
      System.out.println(args[0] + "" + args[1] + args[2] + "=" + "" + result);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("例外");
    }
  }
}
