package Calc;

public class Calc {

  // 四則演算メソッド(strictfp修飾子：小数点も厳密に計算)
  public strictfp static int Calculate(int val1, String symbol, int val2) {
    int result = 0;
      switch (symbol) {
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
