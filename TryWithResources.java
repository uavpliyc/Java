import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        try (MyResource m1 = new MyResource("1");
            MyResource m2 = new MyResource("2")) {
            throw new IOException();
        } catch (Exception e) {
            System.out.println("catch");
        }
    }
}

class MyResource implements AutoCloseable {
    private String str;
    public MyResource(String str) {
        this.str = str;
    }
    public void close() throws Exception {
        System.out.println("close:" + str);
    }
}