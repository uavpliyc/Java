import java.util.Locale;

public class LocaleObject {
  public static void main(String[] args) {
    Locale japan = Locale.getDefault();
    System.out.println(japan.getDisplayCountry() + ":" + japan.getDisplayLanguage());
  }
}