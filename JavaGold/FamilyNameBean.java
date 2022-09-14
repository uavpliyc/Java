package JavaGold;

import gold8.bean.ConverterList;
import gold8.bean.ConvertibleBean;

// 課題4-1：データ格納Beanクラス
public class FamilyNameBean extends ConvertibleBean {

  private String kanji;
  private String hiragana;
  private String English;

  // コンストラクタ
  public FamilyNameBean() {
    super(new ConverterList());
		try {
			addField(s -> kanji = s, () -> kanji);
			addField(s -> hiragana = s, () -> hiragana);
			addField(s -> English = s, () -> English);
		} catch (Exception e) {
			e.printStackTrace();
		}
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