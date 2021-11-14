public class Wizard {
  private int hp;
  private int mp;
  private String name;
  private Wand wand;

  public String getName(){
    return this.name;
  }
  public void setName(String name){
    if(name.length() < 3){
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public int getHp(){
    return this.hp;
  }
  public void setHp(int hp){
    if(hp < 0){
      this.hp = 0;
    }else{
      this.hp = hp;
    }
  }

  public int getMp(){
    return this.mp;
  }
  public void setMp(int mp){
    if(mp < 0){
      throw new IllegalArgumentException("設定するMPが異常です");
    }
    this.mp = mp;
  }

  public Wand getWand(){
    return this.wand;
  }
  public void setWand(Wand wand){
    if(wand == null){
      throw new IllegalArgumentException("杖は必須です");
    }
    this.wand = wand;
  }

  public void heal(Hero h){
    int basePoint = 10;
    // 杖による回復増幅
    int recovPoint = (int)(basePoint * this.getWand().getPower());
    // 勇者のHPを回復
    h.setHp(h.getHp() + recovPoint);
    System.out.println(h.getName() + "のHPを" + recovPoint + "回復した！");
  }
}

// 杖クラス
class Wand {
  private String name;
  private double power;

  public String getName(){
    return this.name;
  }
  public void setName(String name){
    if(name == null || name.length() < 3){
      throw new IllegalArgumentException("杖に設定する名前が異常です");
    }
    this.name = name;
  }

  public double getPower(){
    return this.power;
  }
  public void setPower(double power){
    if(power < 0.5 || power > 100.0){
      throw new IllegalArgumentException("杖に設定する魔力が異常です");
    }
    this.power = power;
  }
}

class Hero {
  public String setHp(String s){
    return null;
  }
  public String getHp(){
    return null;
  }
  public String getMp(){
    return null;
  }
  public String getName(){
    return null;
  }
}