public class InterfaceTest  {
    public static void main(String[] args) {   
        InterImpl ii = new InterImpl();
        ii.Def();

        Inter.Sta();

        D d = new D();
        d.method();
    }
}

interface Inter {
    default void Def() {
        System.out.println("default");
     }
     
     static void Sta() {
        System.out.println("static");
     }
}

class InterImpl implements Inter { };

interface A {
    default void method() {
       System.out.println("A");
    }
 }

interface B extends A { }

interface C extends A {
    default void method() {
       System.out.println("C");
    }
 }

class D implements B, C { }
