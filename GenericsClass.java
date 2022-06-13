import java.util.List;

public class GenericsClass<T> {

    T t;

    List<T> method() {
      return null;
    }

    public void set(T t){
      this.t = t;
    }

}