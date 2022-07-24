public class StringSample {
  public static void main(String[] args){
    String str1 = "HelloWorld"; //アドレス値：100
    String str2 = "Hello";  //アドレス値：200 GC
    str2 = str2 + "World";  //アドレス値：300
    String str3 = new String("HelloWorld");  //アドレス値：400
    String str4 = "HelloWorld";  //アドレス値：100

    System.out.println(str1);
    System.out.println(str2);
    System.out.println(str3);
    System.out.println(str4);


    if(str1.equals(str2)){
      System.out.println("str1.equals(str2)");
    }

    //str1は100,str2は300のアドレス値なのでfalse
    if(str1 == str2){
      System.out.println("str1 == str2");
    }
    else if(str1 == str3){
      System.out.println("str1 == str3");
    }
    else if(str1 == str4){
      System.out.println("str1 == str4");
    }
  }
}
