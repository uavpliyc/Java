public class Sample1 {
  public static void main(String[] args){
    System.out.println("プログラム開始");
    int x = 10;
    try{
      System.out.println("try開始");
      x = x / 0;
      System.out.println("try終了");
    }
    catch(ArithmeticException e){
      System.out.println("例外処理");
    }
    finally{
      System.out.println("finally");
    }
    System.out.println("プログラム終了");
  }
}
