public class VariableLength {
  public static void main(String[] args) {

    VaLe obj = new VaLe();
    int[] ary = {10, 20, 30};
    obj.method("1");
    obj.method("2", 10);
    obj.method("3", 10, 20);
    obj.method("4", ary);

  }
}

class VaLe {
  // 可変長引数(引数の最後に記載)
  public void method(String s, int... i){
    System.out.println(s + "サイズ：" + i.length);
    for(int i2 : i){
      System.out.println("第2引数の値：" + i2);
    }
  }
}