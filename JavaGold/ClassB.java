package JavaGold;

public class ClassB extends ClassA{

  // InterfaceB b = new InterfaceB(){};

  public ClassB(InterfaceB b) {
    super(b);
    // this.b = b;
  }

  public String stringSet(String ... s) {
    String rtnS = null;
    for(String str : s) {
      rtnS = str;
    }
    return rtnS;
  }

  public void display(){

  }

  public void clear(){

  }
  
}