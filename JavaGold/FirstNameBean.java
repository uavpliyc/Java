package JavaGold;

import gold8.bean.ConverterList;
import gold8.bean.ConvertibleBean;

public class FirstNameBean extends ConvertibleBean {
  
  private String Chinese;
  private String hiragana;
  private String English;
  private String sex;

  // コンストラクタ
  public FirstNameBean() {
    super(new ConverterList());
    addField(s -> Chinese = s, () -> Chinese);
    addField(s -> hiragana = s, () -> hiragana);
    addField(s -> English = s, () -> English);
    addField(s -> sex = s, () -> sex);
  }

  public String getChinese() {
    return this.Chinese;
  }

  public void setChinese(String Chinese) {
    this.Chinese = Chinese;
  }

  public String getHiragana() {
    return this.hiragana;
  }

  public void setHiragana(String hiragana) {
    this.hiragana = hiragana;
  }

  public String getEnglish() {
    return this.English;
  }

  public void setEnglish(String English) {
    this.English = English;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

}