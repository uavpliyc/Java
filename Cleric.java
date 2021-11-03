import java.util.Random;

public class Cleric {
  String name;
  int hp = 50;
  final int MAX_HP = 50;
  int mp = 10;
  final int MAX_MP = 10;

  public void selfAid(){
    System.out.println(this.name + "はセルフエイドを唱えた！");
    this.mp -= 5;
    this.hp = MAX_HP;
    System.out.println("HPが最大まで回復した！");
  }
  
  public int pray(int time){
    System.out.println(this.name + "は" +  time + "秒間天に祈った！");
    int recover = new Random().nextInt(3) + time;
    int recoverActual = Math.min(this.MAX_HP - this.mp , recover);
    this.mp += recoverActual;
    System.out.println("MPが" + recoverActual + "回復した！");
    return recoverActual;
  }
}