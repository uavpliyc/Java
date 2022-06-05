import java.util.ListResourceBundle;

public class MyResources extends ListResourceBundle {
  protected Object[][] getContents() {
    Integer intData = 100;
    Object[][] contents = {{"send", "送信"},{"cancel", "取消"},{"intData", intData}};
    return contents;
  }
}