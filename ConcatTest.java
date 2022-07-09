public class ConcatTest {
    public static void main(String[] arg){
      String s1 = "X";
      String s2 = s1 + "Y";
      String s3 = s1.concat("Y");
      System.out.println("s2 == s3:" + s2 == s3);
      System.out.println("s2:" + s2);
      System.out.println("s3:" + s3);
  }
}