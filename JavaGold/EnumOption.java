package JavaGold;

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