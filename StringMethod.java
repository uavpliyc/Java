public class StringMethod {
  public static void main(String[] args) {
    String str1 = "bronze,silver,gold";
    System.out.println(str1.replaceAll("bronze", "silver"));
    System.out.println(str1.indexOf("silver"));
    //Stringはイミュータブル
    System.out.println(str1);
    //◯番目の文字
    System.out.println(str1.charAt(0));

    String s = "123.45";
    // int i = Integer.parseInt(s);
    //NumberFormatException
    // System.out.println(i);

    String str2 = " te st ";
    //trimメソッド：文字列前後の空白を削除
    str2 = str2.trim();
    System.out.println(str2);
    //indexOfメソッド：引数と一致するのは何番目か
    System.out.println(str2.indexOf(" "));

    String str3 = new String("intern");
    String str4 = new String("intern");
    System.out.println(str3 == str4);
    //internメソッド：コンスタントプールを参照
    System.out.println(str3.intern() == "intern");

  }
}