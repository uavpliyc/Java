import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
    public static void main(String[] args) {
        B b = new B();
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"))
        ) {
            oos.writeObject(b);
            System.out.println("シリアライズ完了");
            B readB = (B)ois.readObject();
            System.out.println("デシリアライズ完了");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

class A {
    A() {
        System.out.println("A");
    }
}

class B extends A implements Serializable {
    B() {
        System.out.println("B");
    }
}
