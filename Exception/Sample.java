package Exception;
public class Sample {
  public static void main(String[] args) {

    //Curryクラスのインスタンス化
    Curry curry = new Curry();

    //Curryクラスのフィールドの値を参照
    // String name = curry.name;
    System.out.println(curry.name);

    //Curryクラスのメソッドの実行
    System.out.println(curry.taste());

      //データ型の参照型1(true)
      String sampleA = new String("abc");
      String sampleB = sampleA;
      System.out.println(sampleA);
      System.out.println(sampleB);
      System.out.println("sampleAとsampleBは" + (sampleA == sampleB));
  
       //データ型の参照型1(false)
      String sampleC = new String("abc");
      String sampleD = new String("abc");
      System.out.println(sampleC);
      System.out.println(sampleD);
      System.out.println("sampleCとsampleDは" + (sampleC == sampleD));
  
      //データ型の参照型２
      int[] a = new int[]{1,2,3};
      int[] b = a;
      b[0] = 5;
      System.out.println(a[0]);
  
      //データ型の基本型
      int c = 1;
      int d = c;
      d = 5;
      System.out.println(c);
      System.out.println(d);
  
      int e = 1;
      int f = 1;
      int g = 1;
      f = 2;
      System.out.println(e == f);
      System.out.println(e == g);
  
      String s = "あいうえお";
      String t = "あいうえお";
      System.out.println(s == t);
  }
}