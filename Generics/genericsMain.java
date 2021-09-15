package Generics;
public class genericsMain {
  public static void main(String[] args) {
    generics<String> gene = new generics<String>();
    generics<Integer> gene1 = new generics<Integer>();

    gene.setVal("sample");
    gene1.setVal(100);
    System.out.println(gene.getVal());
    System.out.println(gene1.getVal());
  }
}
