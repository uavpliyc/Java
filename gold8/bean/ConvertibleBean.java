package gold8.bean;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 変換可能Bean.
 * <P>
 * フィールドの値を文字列と変換
 */
public abstract class ConvertibleBean implements IOBean {

    /** 変換器リスト. */
    private final ConverterList converterList;

    /**
     * ConvertibleBeanコンストラクタ.
     *
     * @param converterList 変換器リスト
     */
    public ConvertibleBean(ConverterList converterList) {
        this.converterList = converterList;
    }

    /**
     * 項目追加.
     * <P>
     * 文字列をフィールドへ適したデータ型に変換して格納する処理及び、<BR>
     * 項目値を文字列に変換して返す処理を登録する。<BR>
     * 両変換処理は登録順に順序付けして保持される為、<BR>
     * 入力されるレコードの項目と同じ並び順にする事が推奨される。
     *
     * @param setter 文字列変換設定
     * @param getter 項目値変換取得
     */
    protected void addField(Consumer<String> setter, Supplier<String> getter) {
        converterList.addDefine(setter, getter);
    }

    @Override
    public void set(int index, String data) {
        converterList.setString(index, data);
    }

    @Override
    public String get(int index) {
        return converterList.getString(index);
    }
}
