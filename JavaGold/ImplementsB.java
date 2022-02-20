package JavaGold;

import java.util.ArrayList;

public class ImplementsB implements InterfaceB {
  
  ArrayList<String> list = new ArrayList<>();

  public void display() {
    list.forEach(System.out::println);
  }

  public void clear() {

  }

}