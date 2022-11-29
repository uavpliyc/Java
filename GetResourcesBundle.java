import java.util.Locale;
import java.util.ResourceBundle;

public class GetResourcesBundle {
    public static void main(String[] args) {
        ResourceBundle obj1 = ResourceBundle.getBundle("MyResources", Locale.US);
        System.out.println(obj1.containsKey("apple"));
        String s = (String)obj1.getObject("send");
        System.out.println(s);
    }
}
