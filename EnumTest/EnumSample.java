package EnumTest;

public class EnumSample {

  public static void main(String[] args) {
    Season season = Season.Autumn;

    switch (season) {
      case Spring:
        System.out.println("春");
        break;
      case Summer:
        System.out.println("夏");
        break;
      case Autumn:
        System.out.println("秋");
        break;
      case Winter:
        System.out.println("冬");
        break;
    }

    // ordinalメソッド：添字表示
    System.out.println("ordinal :" + season.ordinal());
    // valuesメソッド
    Season[] arr = Season.values();
    for(Season s : arr) {
      System.out.println("Season :" + s.toString());
    }

  }

  protected enum Season {
    Spring, Summer, Autumn, Winter
  };
}
