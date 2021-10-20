public class Array{
  public static void main(String[] args) {
    int[] array = { 10, 20, 30, 40, 50 };
    System.out.println(array);
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
      System.out.println(array[i] * 1.1);
    }

    int[] array2 = {10, 20, 30, 40, 50};
    System.out.println(array == array2);
  }
}
