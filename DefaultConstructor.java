public class DefaultConstructor {
  private int x = 0, y;

  public DefaultConstructor(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public DefaultConstructor(){
    this(0, 0);
  }
}