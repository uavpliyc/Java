public class StringSample {
  public static void main(String[] args){
    String str1 = "helloworld"; //100
    String str2 = "hello";  //200 GC
    str2 = str2 + "world";  //300
    String str3 = "helloworld";  //100


    //str1は100,str2は300のアドレス値なのでfalse
    if(str1 == str2){
      System.out.println(str1);
      System.out.println(str2);
      System.out.println(str3);
    }
  }
}
