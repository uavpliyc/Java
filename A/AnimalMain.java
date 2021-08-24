package A;

public class AnimalMain {
  public static void main(String[] args){
    Cat tama = new Cat();
    Dog pochi = new Dog();

    Animal[] animal = new Animal[]{tama, pochi};
    AnimalUtil.voices(animal);
  }
}

