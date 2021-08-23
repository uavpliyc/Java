package Calc;
public class Calc {

  //四則演算メソッド
  public static int Calculate(int val1,String symbol,int val2){
    int result = 0;
    switch(symbol){
    case "＋":
      result = val1 + val2;
      break;
    case "−":
      result = val1 - val2;
      break;
    case "×":
      result = val1 * val2;
      break;
    case "÷":
      result = val1 / val2;
      break;
    }
    return result;
  }
}
