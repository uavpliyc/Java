public class RegularExpression {
  public static void main(String[] args) {
    // 「.」：任意の1文字
    System.out.println("Java".matches("J.va"));
    // 「*」：直前文字を0回以上繰り返し
    System.out.println("Javaaa".matches("Java*"));
    // 「{}」：直前文字を◯回繰り返し
    System.out.println("Javaaaaa".matches("Java{5}"));
    // 「[]」：いずれか1文字
    System.out.println("Java".matches("Jav[abcde]"));
    // 「[-]」：指定範囲のいずれか1文字
    System.out.println("java8".matches("[a-z]{4}[0-9]"));
    // 「^」：先頭
    System.out.println("j".matches("^j"));
    // 「$」：末尾
    System.out.println("java".matches("java$"));
  }
}