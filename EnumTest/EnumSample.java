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

    // name,toStringメソッド(列挙定数名取得)
    System.out.println("name:" + Season.Autumn.name());
    System.out.println("toString:" + Season.Autumn.toString());

    // valueOfメソッド(文字列から列挙定数名取得)
    System.out.println("valueOf:" + Season.valueOf("Autumn"));

    // valuesメソッド(列挙値を全て返す)
    Season[] values = Season.values();
    for(Season s : values){
      System.out.println("values[" + s.ordinal()  + "]:" + s);
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
    Spring(1), Summer(2), Autumn(3), Winter(4);

    private final int id;

    // コンストラクタはprivateのみ
    private Season( int id){
      this.id = id;
    }

    public int getId(){
      return id;
    }
  };
}
