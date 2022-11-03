package Generics;
public class generics<E> {
  private E val;

  // クラス型パラメータをstaticメンバに使うと、コンパイルエラー
  // private static E val2;

  public void setVal(E val){
    this.val = val;
  }

  public E getVal(){
    return val;
  }
}
