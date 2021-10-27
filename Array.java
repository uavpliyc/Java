import java.util.ArrayList;

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

    String[] array3 = new String[5];
    array3[0] = "a";
    array3[1] = "b";
    array3[2] = "c";
    //ぬるぽにはならない
    for(String i : array3){
      System.out.println(i);
    }

    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    System.out.println(list);
    
    String[] arr = new String[3];
    arr[1] = "a";
    for (String s : arr){
      System.out.println(s);
    }
    
  }
}
