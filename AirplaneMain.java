public class AirplaneMain {
  public static void main(String[] args) {
    Flyable f = Airplane::new;
    Airplane a = f.getAirplane("飛行機");
    System.out.println(a);
  }
}