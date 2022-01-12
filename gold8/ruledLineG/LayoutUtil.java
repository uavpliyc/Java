package gold8.ruledLineG;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 割当表示補助.
 * <P>
 * {@link exam.silver8.ruledLine.LayoutUtil}をGold SE8の範囲に合わせてソース修正・機能追加したクラス。<BR>
 * 既存メソッドの処理結果に変更は無い。
 */
public class LayoutUtil {

    /**
     * 半角文字列長計算.
     * <p>
     * 文字列の長さを半角文字換算で計算して返す。<br>
     * 例1：ABC ⇒ 3<br>
     * 例2：ＡＢＣ ⇒ 6<br>
     * 例3：ABCＡＢＣ ⇒ 9
     *
     * @param str 文字列
     * @return 半角換算の文字列長
     */
    public static int countHalfLength(String str) {
        int count = 0;

        /* 文字列を1文字ずつに分割し、半角文字は1、全角文字は2で計算 */
        if (str != null && !"".equals(str)) {
            count = Arrays.asList(str.split("(?=.)")).parallelStream()
                    .mapToInt(s -> s.matches("\\p{ASCII}") ? 1 : 2)
                    .sum();
        }

        return count;
    }

    /**
     * 全角文字列長計算.
     * <p>
     * 文字列の長さを全角文字換算で計算して返す。<br>
     * 半角文字が奇数の場合、全角文字1文字分とする。<br>
     * 例1：ABC ⇒ 2<br>
     * 例2：ＡＢＣ ⇒ 3<br>
     * 例3：ABCＡＢＣ ⇒ 5
     *
     * @param str 文字列
     * @return 全角換算の文字列長
     */
    public static int countFullLength(String str) {
        return (int) Math.ceil(countHalfLength(str) / 2.0);
    }

    /**
     * 半角換算部分文字列取得（開始指定）.
     * <p>
     * 文字列の長さを半角換算で計算し、<br>
     * 開始インデックスから末尾までの部分文字列を返す。<br>
     * {@link #substringByHalf(String, int, int)}
     *
     * @param str 文字列
     * @param beginIndex 開始インデックス
     * @return 部分文字列
     */
    public static String substringByHalf(String str, int beginIndex) {
        return substringByHalf(str, beginIndex, countHalfLength(str));
    }

    /**
     * 半角換算部分文字列取得（範囲指定）.
     * <p>
     * 文字列の長さを半角換算で計算し、<br>
     * 開始インデックスから終了インデックスまでの部分文字列を返す。
     *
     * @param str 文字列
     * @param beginIndex 開始インデックス
     * @param endIndex 終了インデックス
     * @return 部分文字列
     */
    public static String substringByHalf(String str, int beginIndex, int endIndex) {
        AtomicInteger count = new AtomicInteger();
        String ret = "";

        /* 文字列を1文字ずつに分割し、半角文字は1、全角文字は2で計算して終了インデックスまで連結 */
        if (str != null && !"".equals(str)) {
            ret = Arrays.asList(str.split("(?=.)")).stream()
                    .peek(s -> count.addAndGet(s.matches("\\p{ASCII}") ? 1 : 2))
                    .filter(s -> beginIndex < count.get() && count.get() <= endIndex)
                    .collect(Collectors.joining());
        }

        return ret;
    }

    /**
     * 全角換算部分文字列取得（開始指定）.
     * <p>
     * 文字列の長さを半角換算で計算し、<br>
     * 開始インデックスから末尾までの部分文字列を返す。<br>
     * {@link #substringByFull(String, int, int)}
     *
     * @param str 文字列
     * @param beginIndex 開始インデックス
     * @return 部分文字列
     */
    public static String substringByFull(String str, int beginIndex) {
        return substringByFull(str, beginIndex, countFullLength(str));
    }

    /**
     * 半角換算部分文字列取得（範囲指定）.
     * <p>
     * 文字列の長さを全角換算で計算し、<br>
     * 開始インデックスから終了インデックスまでの部分文字列を返す。
     *
     * @param str 文字列
     * @param beginIndex 開始インデックス
     * @param endIndex 終了インデックス
     * @return 部分文字列
     */
    public static String substringByFull(String str, int beginIndex, int endIndex) {
        return substringByHalf(str, beginIndex * 2, endIndex * 2);
    }

    /**
     * 空白埋め.
     * <p>
     * 文字列を指定された幅まで空白埋めする。<br>
     * 半角フラグがtrueの場合は幅と文字列長を半角換算で計算して空白埋めし、<br>
     * falseの場合は幅と文字列長を全角換算で計算して空白埋めする。<br>
     * 全角空白埋めの場合は半角スペース2つを設定する。
     *
     * @param str 文字列
     * @param width 幅
     * @param isHalf 半角フラグ
     * @return 空白埋め済文字列
     * @see #fillBlank(String, int, boolean, Align)
     */
    public static String fillBlank(String str, int width, boolean isHalf) {
        return fillBlank(str, width, isHalf, Align.LEFT);
    }

    /**
     * 空白埋め（整列）.
     * <p>
     * 文字列を指定された幅まで整列して空白埋めする。<br>
     * 半角フラグがtrueの場合は幅と文字列長を半角換算で計算して空白埋めし、<br>
     * falseの場合は幅と文字列長を全角換算で計算して空白埋めする。<br>
     * 全角空白埋めの場合は半角スペース2つを設定する。
     *
     * @param str 文字列
     * @param width 幅
     * @param isHalf 半角フラグ
     * @param align 整列
     * @return 空白埋め済文字列
     */
    public static String fillBlank(String str, int width, boolean isHalf, Align align) {
        int strLen = isHalf ? LayoutUtil.countHalfLength(str) : LayoutUtil.countFullLength(str);
        String blank = isHalf ? " " : "  ";
        String space = "";

        if (strLen < width) {
            space = IntStream.range(0, width - strLen)
                    .mapToObj(i -> blank)
                    .collect(Collectors.joining());
        }

        return align.format(str, space);
    }

    /**
     * 整列.
     * <P>
     * LEFT：文字列が左揃えになるよう、右側へ空白埋め文字を連結する。<BR>
     * CENTER：文字列が中央揃えになるよう、空白埋め文字を分割して前後へ連結する。<BR>
     * RIGHT：文字列が右揃えになるよう、左側へ空白埋め文字を連結する。
     */
    public enum Align {
        LEFT((str, space) -> str + space),
        CENTER((str, space) -> {
            int centerIndex = space.length() / 2;
            return space.substring(0, centerIndex) + str + space.substring(centerIndex);
        }),
        RIGHT((str, space) -> space + str);

        private BinaryOperator<String> formatter;

        Align(BinaryOperator<String> formatter) {
            this.formatter = formatter;
        }

        /**
         * 整列書式化.
         * <P>
         * 文字列の前後に空白埋め文字を連結し、<BR>
         * 指定された位置へ整列した状態に整形して返す。
         *
         * @param str 文字列
         * @param space 空白埋め文字
         * @return 整列後文字列
         */
        public String format(String str, String space) {
            return formatter.apply(str, space);
        }
    }

    /**
     * 行リスト変換.
     * <P>
     * 文字列二重配列を行毎のリストとして返す。
     *
     * @param params 文字列二重配列
     * @return 行リスト
     */
    public static List<List<String>> parseList(String[][] params) {
        return Arrays.asList(params).stream()
                .map(a -> Arrays.asList(a))
                .collect(Collectors.toList());
    }

    /**
     * 行リスト変換.
     * <P>
     * 列リストの設定値を全て文字列に変換し、行毎のリストとして返す。
     *
     * @param columns 列リスト（可変長）
     * @return 行リスト
     */
    public static List<List<String>> parseList(List<?>... columns) {
        List<List<?>> columnList = Arrays.asList(columns);
        int maxSize = columnList.stream().mapToInt(e -> e.size()).max().getAsInt();

        return IntStream.range(0, maxSize).mapToObj(i -> columnList.stream()
                .map(e -> i < e.size() ? e.get(i) : "")
                .map(String::valueOf)
                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
