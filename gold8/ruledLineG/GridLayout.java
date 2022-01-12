package gold8.ruledLineG;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 格子割当表示.
 * <p>
 * {@link exam.silver8.ruledLine.GridLayout}をGold SE8の範囲に合わせてソース修正・機能追加したクラス。<BR>
 * 既存メソッドの処理結果に変更は無い。
 */
public class GridLayout extends SimpleLayout {

    /**
     * GridLayoutコンストラクタ.
     * <p>
     * 標準項目幅に初期値（5）を設定して{@link #GridLayout(String[][], int)}を呼び出す。
     * @param params 項目配列
     */
    public GridLayout(String[][] params) {
        this(LayoutUtil.parseList(params));
    }

    /**
     * GridLayoutコンストラクタ.
     * <p>
     * 最大項目幅に初期値（10）を設定して{@link #GridLayout(String[][], int, int)}を呼び出す。
     * @param params 項目配列
     * @param defaultWidth 標準項目幅
     */
    public GridLayout(String[][] params, int defaultWidth) {
        this(LayoutUtil.parseList(params), defaultWidth);
    }

    /**
     * GridLayoutコンストラクタ.
     * <p>
     * {@link SimpleLayout#SimpleLayout(String[][])}に項目配列を渡す。
     * @param params 項目配列
     * @param defaultWidth 標準項目幅
     * @param maxWidth 最大項目幅
     */
    public GridLayout(String[][] params, int defaultWidth, int maxWidth) {
        this(LayoutUtil.parseList(params), defaultWidth, maxWidth);
    }

    /**
     * GridLayoutコンストラクタ.
     * <p>
     * 標準項目幅に初期値（5）を設定して{@link #GridLayout(String[][], int)}を呼び出す。
     * @param rowList 行リスト
     */
    public GridLayout(List<List<String>> rowList) {
        this(rowList, 5);
    }

    /**
     * GridLayoutコンストラクタ.
     * <p>
     * 最大項目幅に初期値（10）を設定して{@link #GridLayout(String[][], int, int)}を呼び出す。
     * @param rowList 行リスト
     * @param defaultWidth 標準項目幅
     */
    public GridLayout(List<List<String>> rowList, int defaultWidth) {
        this(rowList, defaultWidth, 10);
    }

    /**
     * GridLayoutコンストラクタ.
     * <P>
     * 全角文字の項目幅を指定し
     * @param rowList 行リスト
     * @param defaultWidth 標準項目幅
     * @param maxWidth 最大項目幅
     */
    public GridLayout(List<List<String>> rowList, int defaultWidth, int maxWidth) {
        super(rowList, s -> {
            int paramLen = LayoutUtil.countFullLength(s);
            return paramLen <= defaultWidth ? defaultWidth : maxWidth < paramLen ? maxWidth : paramLen;
        });
    }

    protected String createHead() {
        return createBorder("┏", "━", "┯", "┓");
    }

    protected String createBody() {
        return getParams().stream().map(p -> createNewLinedRow(p))
                .collect(Collectors.joining(createBorder("┠", "─", "┼", "┨")));
    }

    protected String createFoot() {
        return createBorder("┗", "━", "┷", "┛");
    }

    /**
     * 横線作成.
     * <p>
     * {@link SimpleLayout#createBorder(Supplier, Function, Function)}
     *
     * @param lineStart 行頭文字列
     * @param middle 項目途中文字列
     * @param paramEnd 項目末尾文字列
     * @param lineEnd 行末文字列
     * @return 横線文字列
     */
    protected String createBorder(String lineStart, String middle, String paramEnd, String lineEnd) {
        return createBorder(
                () -> lineStart,
                w -> IntStream.range(0, w).mapToObj(i -> middle)
                    .collect(Collectors.reducing(new StringBuilder(), StringBuilder::new, (a, p) -> a.append(p))).toString(),
                i -> i + 1 < getWidthList().size() ? paramEnd : lineEnd + "\r\n");
    }

    /**
     * 改行済み行作成.
     * <p>
     * 項目リストを各列幅に収まるよう改行した文字列を返す。
     *
     * @param row 項目リスト
     * @return 改行済み行文字列
     * @see #getNewLinedParam(String, int, int)
     */
    private String createNewLinedRow(List<String> row) {
        /* 改行した行毎に文字列整形し、改行毎の各項目値を連結 */
        return IntStream.range(0, countRowHight(row))
                .mapToObj(i -> IntStream.range(0, row.size())
                        .mapToObj(j -> getNewLinedParam(row.get(j), getWidthList().get(j), i))
                        .collect(Collectors.joining("│", "┃", "┃\r\n")))
                .collect(Collectors.joining());
    }

    /**
     * 改行済み項目値取得.
     * <P>
     * 項目値を項目幅に合わせて改行させた場合、<BR>
     * 改行済み数の次行に当たる部分文字列を返す。<BR>
     * 部分文字列が項目幅未満であれば半角空白埋めする。
     *
     * @param param 項目値
     * @param width 項目幅
     * @param newLinedCount 改行済み数
     * @return 改行済み項目値
     */
    private String getNewLinedParam(String param, int width, int newLinedCount) {
        assert 0 < width;
        int beginIndex = width * newLinedCount;
        String paramPart = LayoutUtil.substringByFull(param, beginIndex, beginIndex + width);
        return LayoutUtil.fillBlank(paramPart, width * 2, true, getAlign());
    }

    /**
     * 行高さ計算.
     * <p>
     * 各項目の文字列長を全角換算で各列幅に収まるよう、<br>
     * 改行した場合の行数を計算する。
     *
     * @param row 項目配列
     * @return 行高さ
     */
    private int countRowHight(List<String> row) {
        return IntStream.range(0, row.size())
                .map(i -> (int) Math.ceil(LayoutUtil.countFullLength(row.get(i)) / (double) getWidthList().get(i)))
                .map(i -> i == 0 ? 1 : i)
                .max().getAsInt();
    }
}
