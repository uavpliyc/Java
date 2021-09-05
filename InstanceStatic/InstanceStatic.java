package InstanceStatic;
public class InstanceStatic {
    //インスタンス変数
    int instanceVal = 10;
    //static変数
    static int staticVal = 100;
    //インスタンスメソッド
    void instanceMethod(){
      System.out.println(instanceVal);
    }
    //staticメソッド
    static void staticMethod(){
      System.out.println(staticVal);
    }

    //①インスタンスメソッド→インスタンス変数
    int A(){
      return instanceVal;
    }
    //②インスタンスメソッド→static変数
    int B(){
      return staticVal;
    }
    //③staticメソッド→static変数
    static int C(){
      return staticVal;
    }
    //④staticメソッド→インスタンス変数
    // static int D(){
    //   return instanceVal;
    // }
    //⑤インスタンス化→staticメソッド→インスタンス変数
    static int D(){
      InstanceStatic y = new InstanceStatic();
      return y.instanceVal;
    }
}
