import java.text.DecimalFormat;

public class CustomFormat {
    public static void main(String[] args) {
        customFormat("###.##", 123456.789);
        customFormat("000.000", 1234.567);
        customFormat("###.##", 1.2);
        customFormat("000.000", 1.2);
        customFormat("\u00a5#,###", 1234);
    }

    static void customFormat(String pattern, double val) {
        DecimalFormat format = new DecimalFormat(pattern);
        String s = format.format(val);
        System.out.println(s);
    }
}
