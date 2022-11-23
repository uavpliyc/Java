package Exception;

import java.io.IOException;

public class ThrowsTest {

    public static void main(String[] args) {
        try {
            testA();
            testB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void testA() throws ArrayStoreException {
    // static void testA() {    // OK（uncheck例外）
        throw new ArrayStoreException();
    }

    static void testB() throws IOException {
    // static void testB() {    // コンパイルエラー（check例外）
        throw new IOException();
    }
}
