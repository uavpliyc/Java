import java.util.Arrays;
import java.util.List;

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

    String[] arr = new String[3];
    arr[1] = "a";
    for (String s : arr){
      System.out.println(s);
    }

    // cloneメソッド：新しい配列を生成し、要素をコピー
    int[][] intA = {{1,2,3},{4,5,6}};
    int[][] intB = intA.clone();
    for (int i : intA[0]){
      System.out.println(i);
    }
    System.out.println(intA == intB);
    System.out.println(intA[0] == intB[0]);

    String[] arr2 = {"a", "b", "c"};
    // asListメソッド：配列をリストに変換
    List<String> list = Arrays.asList(arr2);
    // list.add("d"); →UnsupportedOperationException:元は配列だから、固定サイズ
    for(int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
