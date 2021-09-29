package EnumTest;

public class EnumSample {

  public static void main(String[] args) {
    Name name = Name.Tanaka;

    switch (name) {
      case Tanaka:
        System.out.println(1);
        break;
      case Sato:
        System.out.println(2);
        break;
      case Kimura:
        System.out.println(3);
        break;
    }
  }

  protected enum Name {
    Tanaka, Sato, Kimura
  };
}
