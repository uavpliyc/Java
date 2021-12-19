import java.util.Locale;

public class LocaleObject {
  public static void main(String[] args) {
    Locale japan = Locale.getDefault();
    System.out.println(japan.getDisplayCountry());
    System.out.println(japan.getDisplayLanguage());

    Locale us = Locale.US;

    System.out.println(us.getDisplayCountry());
    System.out.println(us.getDisplayLanguage());

    System.out.println(us.getDisplayCountry(us));
    System.out.println(us.getDisplayLanguage(us));
  }
}