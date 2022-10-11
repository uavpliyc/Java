package JavaGold;

// 課題7-3：列挙型を用いてオプションの制御を改善する
public enum EnumOption {

  FINISH("end");

  private String op;

  private EnumOption(String op) {
    this.op = op;
  }

  public String getOp() {
    return op;
  }

}