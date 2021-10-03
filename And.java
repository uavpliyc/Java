class And {
  public static void main(String[] args) {
    int a = 1;
    int b = 1;
    int c = 2;
    if (a == b) {
      System.out.println("aとbは等しい");
    }
    if ((a == b) && (a == c)) {
      System.out.println("aとbは等しい、かつ、aとcは等しい");
    }
    if ((a == b) || (a == c)) {
      System.out.println("aとbは等しい、または、aとcは等しい");
    }
    String test1 = "abc";
    String test2 = "abc";
    if(test1 == test2){
      System.out.println("test1はtest2と等しい");
    }
    if(test1.equals(test2)){
      System.out.println("test1はtest2と等しい");
    }

    AndTest str1 = new AndTest();
    AndTest str2 = new AndTest();
    if(str1.str == str2.str){
      System.out.println("str1はstr2と等しい");
    }
    if(str1.str.equals(str2.str)){
      System.out.println("str1はstr2と等しい");
    }
  }
}

class AndTest{
  public String str = "str";
}