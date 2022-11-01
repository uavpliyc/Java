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
      case NA:
        System.out.println("NA");
        break;
    }

    // name,toStringメソッド(列挙定数名取得)
    System.out.println("name:" + Season.Autumn.name());
    System.out.println("toString:" + Season.Autumn.toString());

    // valueOfメソッド(文字列から列挙定数名取得)
    System.out.println("valueOf:" + Season.valueOf("Autumn"));

    // 列挙値の引数は定義したゲッターを使用
    System.out.println("getId:" + Season.Autumn.getId());

    // valuesメソッド(列挙値を全て返す)
    Season[] values = Season.values();
    for(Season s : values){
      System.out.println("values[" + s.ordinal()  + "]:" + s);
    }

    // ordinalメソッド：添字表示(0スタート)
    System.out.println("ordinal :" + Season.Autumn.ordinal());

  }

  protected enum Season {
    Spring(1), Summer(2), Autumn(3), Winter(4), NA;

    private int id;

    // コンストラクタはprivateのみ
    private Season(int id){
      this.id = id;
    }

    // コンストラクタのオーバーロード（NAは初期値0になる）
    private Season() {

    }

    public int getId(){
      return id;
    }
  }

  protected enum Test {
    //各列挙値内でオーバーライドしないとコンパイルエラー
    A{void method() {
      System.out.println("A");
    }},
    B{void method() {
      System.out.println("B");
    }};

    // 抽象メソッド
    abstract void method();
  }
}
