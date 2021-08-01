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
  }
}