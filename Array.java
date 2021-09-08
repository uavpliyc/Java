public class Array {
  public static void main(String[] args) {
    String name = args[0];
    int num = name.length();
    char c = name.charAt(0);
    System.out.println(num);
    System.out.println(c);

    int[] array = { 10, 20, 30, 40, 50 };
    array[2] = Integer.parseInt(args[0]);
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
      System.out.println(array[i] * 1.1);
    }
  }
}
