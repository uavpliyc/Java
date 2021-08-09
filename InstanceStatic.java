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

    //インスタンスメソッド→インスタンス変数
    int A(){
      return instanceVal;
    }
    //インスタンスメソッド→static変数
    int B(){
      return staticVal;
    }
    //staticメソッド→static変数
    static int C(){
      return staticVal;
    }
    //staticメソッド→インスタンス変数
    // static int D(){
    //   return instanceVal;
    // }
    //インスタンス化→staticメソッド→インスタンス変数
    static int D(){
      InstanceStatic y = new InstanceStatic();
      return y.instanceVal;
    }
}
