import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

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
      System.out.println(obj.getString("send"));
      System.out.println(obj.getString("cancel"));
    }

    ResourceBundle obj = ResourceBundle.getBundle("MyResources");
    // リソースバンドル(keySet)
    Set<String> keys = obj.keySet();
    keys.stream()
      .map(k -> obj.getString(k))
      .forEach(System.out::println);

  }
}