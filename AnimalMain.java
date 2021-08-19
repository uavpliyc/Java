public class AnimalMain {
  public static void main(String[] args){
    Cat tama = new Cat();
    Dog pochi = new Dog();

    Animal[] animal = new Animal[]{tama, pochi};
    voices(animal);
  }


  private static void voices(Animal[] animals){
    for(Animal animal : animals){
      animal.voice();
    }
  }
}
