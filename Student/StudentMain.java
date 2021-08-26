package Student;
public class StudentMain {
  public static void main(String[] args){

    Student.race = "日本人";

    Student tanaka = new Student(); 
    Student suzuki = new Student(); 
  
    tanaka.name = "田中";
    tanaka.age = 29;
  
    //tanaka = suzuki;

    suzuki.name = "鈴木";
    suzuki.age = 25;
  
    tanaka.Self("田中です");
    suzuki.Self("鈴木です");
  
  }
}
