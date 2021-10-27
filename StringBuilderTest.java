public class StringBuilderTest{
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("Java");
    sb.insert(1, "SE");
    sb.append("Version8");
    sb.delete(3,6);
    System.out.println(sb);
    //capacityメソッド：バッファ容量確認
    System.out.println(sb.capacity());

    StringBuilder sb2 = new StringBuilder("abcd");
    System.out.println(sb2.capacity());
    
    // replaceメソッド：0から(2-1)番目までを変える
    sb2.replace(0, 2, "x");
    System.out.println(sb2);
    
  }
}