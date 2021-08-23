package A;

public class AnimalUtil {
  public static void voices(Animal[] animals){
    for(Animal animal : animals){
      animal.voice();
    }
  }
}
