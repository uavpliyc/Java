class Main {
  public static void main(String[] args) {
    int x = 10;
    int y = 50;
    int answer = x * y;
    char data[] = {'a','b'};

    System.out.println(data);
    System.out.println("答えは" + answer);
    if (x <= y) {
      System.out.println("xはy以下です");
    }
    for(int i = 0; i <= 100; i++){
      if(i % 2 == 0){
        System.out.println(i + "は偶数");
      }
    }
  }
}
