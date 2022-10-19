import java.util.Arrays;

public class LengthCheckerMain {
  public static void main(String[] args) {
    String[] fruits = new String[]{"Orange", "Apple", "Strawberry"};
    Arrays.sort(fruits, LengthChecker::check);
    System.out.println(Arrays.toString(fruits));
  }
}