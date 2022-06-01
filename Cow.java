class Animal {
  public static void say(){
    System.out.println("Animal!");
  }
}

public class Cow extends Animal {
  // ※staticメソッドはオーバーライドされない！
  public static void say(){
    System.out.println("Moo!");
  }
  public static void main(String[] args) {
    Animal[] animals = {new Animal(), new Cow()};
    for (Animal a: animals){
      say();
      System.out.println(a);
    }
    say();
  }
}