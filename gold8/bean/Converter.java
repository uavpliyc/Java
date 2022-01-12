package gold8.bean;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 変換器.
 * <P>
 * 文字列とのデータ変換を中継する為、<BR>
 * 変換と変数への格納機能を備えたConsumerとSupplierを保持する。
 */
public class Converter {

    /** 変換元設定. */
    private Consumer<String> setter;
    /** 変換後取得 */
    private Supplier<String> getter;

    /**
     * Converterコンストラクタ.
     * <P>
     * @param setter 変換元設定
     * @param getter 変換後取得
     */
    public Converter(Consumer<String> setter, Supplier<String> getter) {
        this.setter = setter;
        this.getter = getter;
    }

    /**
     * 変換前文字列設定.
     *
     * @param str 変換前文字列
     */
    public void set(String str) {
        setter.accept(str);
    }

    /**
     * 変換後文字列取得.
     *
     * @return 変換後文字列
     */
    public String get() {
        return getter.get();
    }
}
