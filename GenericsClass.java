import java.util.List;

public class GenericsClass<T> {

    T t;

    // staticメンバに型パラメータはコンパイルエラー
    // static T val;

    List<T> method() {
      return null;
    }

    public void set(T t){
      this.t = t;
    }

}