public class MakeMethod {
  public static void main(String[] args) {
    introduceOneself();
    email("連絡", "田中様", "明日は休暇です");
    email("清水様", "完了報告です");
    System.out.println("三角形の面積：" + calcTriangleArea(10.0, 5.0) + "平方cm");
    System.out.println("円の面積：" + calcCircleArea(5.0) + "平方cm");
  }

  public static void introduceOneself(){
    String name = "田中";
    int age = 28;
    double tall = 163.5;
    char eto = '未';
    System.out.println("名前：" + name + " 年齢：" + age + " 身長：" + tall + " 干支：" + eto);
  }

  public static void email(String title, String address, String text){
      System.out.println(address + "に、以下のメールを送信しました");
      System.out.println("件名：" + title);
      System.out.println("本文：" + text);
  }

  public static void email(String address, String text){
    System.out.println(address + "に、以下のメールを送信しました");
    System.out.println("件名：無題");
    System.out.println("本文：" + text);
  }

  public static double calcTriangleArea(double bottom, double height){
    double area = bottom * height / 2;
    return area;
  }

  public static double calcCircleArea(double radius){
    double area = radius * radius * 3.14;
    return area;
  }
}