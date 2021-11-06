public class StringMethod {
  public static void main(String[] args) {
    String str1 = "bronze,silver,gold";
    System.out.println(str1.replaceAll("bronze", "silver"));
    System.out.println(str1.indexOf("silver"));
    //Stringはイミュータブル
    System.out.println(str1);
    //charAtメソッド：◯番目の文字
    System.out.println(str1.charAt(0));

    // String s = "123.45";
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

    //replaceAllメソッド：第１引数の文字列を第２引数文字列に変更したインスタンスを生成
    String str5 = str2.replaceAll(" ", "?");
    System.out.println(str5);
    System.out.println(String.valueOf(str5));

    //toUpperCaseメソッド：大文字に変換
    System.out.println(str5.toUpperCase());
    
    // formatメソッド：第1引数に雛形、第2引数に指定値
    // d:整数、s:文字列、f:小数、b:真偽値
    final String FORMAT = "名前：%s年齢：%d";
    String s = String.format(FORMAT, "田中", 28);
    System.out.println(s);
  }
}