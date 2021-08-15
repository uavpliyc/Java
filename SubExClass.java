class SubExClass extends ExClass {
  public void increase(int i) { // 引数を1000倍にするメソッド
    int x = i * 1000;
    System.out.println(x);
  }
  public void increase2(int i){
    super.increase(i);
  }
}
