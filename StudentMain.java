public class StudentMain {
  public static void main(String[] args){

    Student taro = new Student(); 
    Student jiro = new Student(); 
  
    taro.name = "taro";
    taro.age = 25;
  
    jiro.name = "jiro";
    jiro.age = 22;
  
    taro.Self("よろ");
    jiro.Self("仲良く");
  
  }
}
