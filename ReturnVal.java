public class ReturnVal {
  public static void main(String[] args){
    int n = 10;
    int total = calc(n);
    System.out.println(total);
    int[] arr = {1,2,3};
    // voidでも参照渡しなので変わる
    calc2(arr);
    for (int i : arr){
      System.out.println(i);
    }
  }

  public static int calc(int num){
    num += 100;
    //返さないと演算されない
    return num;
  }
  
  public static void calc2(int[] num){
    for (int i = 0; i < num.length; i++) {
      num[i] += 10;
    }
  }
}
