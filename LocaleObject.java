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

    // リソースバンドル
    Locale[] locArray = {japan, us};
    for (Locale locale : locArray) {
      ResourceBundle obj = ResourceBundle.getBundle("MyResources", locale);
      System.out.println(obj.getString("send"));
      System.out.println(obj.getString("cancel"));
    }
  }
}