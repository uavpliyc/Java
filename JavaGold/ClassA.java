package JavaGold;

public class ClassA {

  InterfaceA a = new InterfaceA(){

  };

  public ClassA(InterfaceA a){
    a = this.a;
  }

  public void setAndExecute(String... s) {
    for(String str : s) {
      a.set(str);
      a.execute();
    }
  }

}