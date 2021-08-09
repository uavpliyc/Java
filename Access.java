public class Access {
  //private修飾子のstatic変数
  private int A;

  public Access(int B){
    A = B;
  }
  //public修飾子のstatic変数
  public int getB(){
    return A;
  }
}


