public class StringBuilderTest{
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("Java");
    sb.insert(1, "SE");
    sb.append("Version8");
    sb.delete(3,6);
    System.out.println(sb);
    System.out.println(sb.capacity());

    StringBuilder sb2 = new StringBuilder("abcd");
    System.out.println(sb2.capacity());
  }
}