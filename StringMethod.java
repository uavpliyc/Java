public class StringMethod {
  public static void main(String[] args) {
    String str1 = "bronze,silver,gold";
    System.out.println(str1.replaceAll("bronze", "silver"));
    System.out.println(str1.indexOf("silver"));
    System.out.println(str1);
    System.out.println(str1.charAt(0));
  }
}