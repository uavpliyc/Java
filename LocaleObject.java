import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleObject {
  public static void main(String[] args) {
    // Localオブジェクト
    Locale japan = Locale.getDefault();
    System.out.println(japan.getDisplayCountry());
    System.out.println(japan.getDisplayLanguage());

    Locale us = Locale.US;

    System.out.println(us.getDisplayCountry());
    System.out.println(us.getDisplayLanguage());

    System.out.println(us.getDisplayCountry(us));
    System.out.println(us.getDisplayLanguage(us));

    Locale[] locArray = {japan, us};
    // リソースバンドル(拡張for文)
    for (Locale locale : locArray) {
      ResourceBundle obj = ResourceBundle.getBundle("MyResources", locale);
      // String型以外はgetObjectで取得し、キャストが必要
      Integer data = (Integer)obj.getObject("intData");
      System.out.println("intData：" + data);
      System.out.println("send：" + obj.getString("send"));
      System.out.println("cancel：" + obj.getString("cancel"));
    }

  }
}