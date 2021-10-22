public class Loop {
  public static void main(String[] args) {
    int i = 0;
    String[] str = {"A","B","C"};
    for(String list: str){
      // iを初期化しないため、3でfalseになる
      for( ; i<3 ; i++){
        System.out.print(i);
      }
    }
  }
}