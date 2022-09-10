package JavaGold;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

// シリアライズ(オブジェクトを入出力可能)
public class People implements Serializable {

  private int id;
  private String kanji;
  private String yomi;
  private String romaji;
  private String sex;
  private LocalDate birthday;
  private LocalDateTime registerDate;
  private long insurance;
  private int premium;

  // コンストラクタ
  public People(int id,String kanji,String yomi,String romaji,String sex,LocalDate birthday,LocalDateTime registerDate,long insurance,int premium) {
    this.id = id;
    this.kanji = kanji;
    this.yomi = yomi;
    this.sex = sex;
    this.birthday = birthday;
    this.registerDate = registerDate;
    this.insurance = insurance;
    this.premium = premium;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getKanji() {
    return this.kanji;
  }

  public void setKanji(String kanji) {
    this.kanji = kanji;
  }

  public String getYomi() {
    return this.yomi;
  }

  public void setYomi(String yomi) {
    this.yomi = yomi;
  }

  public String getRomaji() {
    return this.romaji;
  }

  public void setRomaji(String romaji) {
    this.romaji = romaji;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public LocalDate getBirthday() {
    return this.birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public LocalDateTime getRegisterDate() {
    return this.registerDate;
  }

  public void setRegisterDate(LocalDateTime registerDate) {
    this.registerDate = registerDate;
  }

  public long getInsurance() {
    return this.insurance;
  }

  public void setInsurance(long insurance) {
    this.insurance = insurance;
  }

  public int getPremium() {
    return this.premium;
  }

  public void setPremium(int premium) {
    this.premium = premium;
  }
  
}