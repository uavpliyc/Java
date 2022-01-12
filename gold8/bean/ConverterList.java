package gold8.bean;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 変換器リスト.
 */
public class ConverterList extends ArrayList<Converter> {

    /**
     * 定義追加.
     *
     * @param setter 変換元設定
     * @param getter 変換後取得
     */
    public void addDefine(Consumer<String> setter, Supplier<String> getter) {
        add(new Converter(setter, getter));
    }

    /**
     * 変換前文字列設定.
     *
     * @param index 項目番号
     * @param str 変換前文字列
     */
    public void setString(int index, String str) {
        get(index).set(str);
    }

    /**
     * 変換後文字列取得.
     *
     * @param index 項目番号
     * @return 変換後文字列
     */
    public String getString(int index) {
        return get(index).get();
    }
}
