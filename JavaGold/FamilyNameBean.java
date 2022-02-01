package JavaGold;

import gold8.bean.ConverterList;
import gold8.bean.ConvertibleBean;

public class FamilyNameBean extends ConvertibleBean {
  
  private String kanji;
  private String hiragana;
  private String English;

  // コンストラクタ
  public FamilyNameBean() {
    super(new ConverterList());
    addField(s -> kanji = s, () -> kanji);
    addField(s -> hiragana = s, () -> hiragana);
    addField(s -> English = s, () -> English);
  }

	public String getKanji() {
		return this.kanji;
	}

	public void setKanji(String kanji) {
		this.kanji = kanji;
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


}