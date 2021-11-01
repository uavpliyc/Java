public class MakeMethod {
  public static void main(String[] args) {
    introduceOneself();
    email("連絡", "田中様", "明日は休暇です");
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
}