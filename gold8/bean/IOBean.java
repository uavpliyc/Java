package gold8.bean;

/**
 * 入出力Bean.
 * <P>
 * Beanの項目値を入出力に用いる為、<BR>
 * 順序付けした項目値を文字列と相互変換して設定・取得する。
 */
public interface IOBean {

    /**
     * 項目値設定.
     *
     * @param index 項目番号
     * @param data 項目値
     */
    void set(int index, String data);

    /**
     * 文字列化項目値取得.
     *
     * @param index 項目番号
     * @return 文字列化項目値
     */
    String get(int index);
}
