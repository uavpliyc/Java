public class ReturnVal {
  public static void main(String[] args){
    int n = 10;
    int total = calc(n);
    System.out.println(total);
    System.out.println(total % 2);
  }
  public static int calc(int num){
    num += 100;
    //返さないと演算されない
    return num;
  }
}
