package Generics;
public class genericsMain {
  public static void main(String[] args) {
    generics<String> gene = new generics<String>();

    gene.setVal("sample");
    System.out.println(gene.getVal());
  }
}
