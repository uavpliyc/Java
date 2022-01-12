package gold8.ruledLineG;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * 簡易割当表示.
 * <p>
 * {@link exam.silver8.ruledLine.SimpleLayout}をGold SE8の範囲に合わせてソース修正・機能追加したクラス。<BR>
 * 既存メソッドの処理結果に変更は無い。
 */
public class SimpleLayout implements Layout {

    /** 項目配列. */
    private List<List<String>> paramList = new ArrayList<>();
    /** 幅計算関数. */
    private Function<String, Integer> calcWidth;
    /** 項目幅リスト. */
    private List<Integer> widthList = new ArrayList<>();
    /** 項目名. */
    private List<String> header;
    /** 整列. */
    private LayoutUtil.Align align;

    /**
     * SimpleLayoutコンストラクタ.
     * <p>
     * {@link #SimpleLayout(String[][], Function)}
     * @param paramList 項目配列
     */
    public SimpleLayout(String[][] params) {
        this(params, LayoutUtil::countFullLength);
    }

    /**
     * SimpleLayoutコンストラクタ,
     * <p>
     * {@link SimpleLayout}
     * @param paramList 項目配列
     * @param calcWidth 幅計算関数
     */
    public SimpleLayout(String[][] params, Function<String, Integer> calcWidth) {
        this(LayoutUtil.parseList(params), calcWidth);
    }

    /**
     * SimpleLayoutコンストラクタ,
     * <p>
     * @param rowList
     */
    public SimpleLayout(List<List<String>> rowList) {
        this(rowList, LayoutUtil::countFullLength);
    }

    /**
     *
     * @param rowList
     * @param calcWidth
     */
    public SimpleLayout(List<List<String>> rowList, Function<String, Integer> calcWidth) {
        this.paramList = rowList;
        this.calcWidth = calcWidth;
        align = LayoutUtil.Align.LEFT;

        initWidthList();
    }

    /**
     * 項目幅リスト初期化.
     */
    protected void initWidthList() {
        paramList.stream().forEach(r -> IntStream.range(0, r.size()).forEach(i -> {
            int width = calcWidth.apply(r.get(i));

            /* 列の幅追加。同じ列の幅はより大きい方で上書きする。 */
            if (widthList.size() <= i) {
                widthList.add(width);
            } else {
                widthList.set(i, Math.max(width, widthList.get(i)));
            }
        }));
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(createHead());

        output.append(createBody());

        output.append(createFoot());

        return output.toString();
    }

    /**
     * 項目配列取得.
     * @return 項目配列
     */
    public List<List<String>> getParams() {
        return paramList;
    }

    /**
     * 項目幅リスト取得.
     * @return 項目幅リスト
     */
    public List<Integer> getWidthList() {
        return widthList;
    }

    /**
     * 先頭作成.
     * @return 表示用先頭文字列
     */
    protected String createHead() {
        StringBuilder ret = new StringBuilder();
        ret.append(createRow(paramList.get(0)));
        ret.append(createBorder(
                () -> "",
                w -> IntStream.range(0, w).mapToObj(i -> "─").collect(Collectors.joining()),
                i -> i + 1 < widthList.size() ? "┼" : "\r\n"));
        return ret.toString();
    }

    /**
     * 本文作成.
     * @return 表示用本文文字列
     */
    protected String createBody() {
        List<List<String>> body = paramList.subList(1, paramList.size());
        return body.stream().map(p -> createRow(p)).collect(Collectors.joining());
    }

    /**
     * 末尾作成,
     * @return 表示用末尾文字列
     */
    protected String createFoot() {
        return "";
    }

    /**
     * 行作成.
     * @param row 項目配列
     * @return 行文字列
     */
    protected String createRow(List<String> row) {
        StringBuilder ret = new StringBuilder();
        AtomicInteger ai = new AtomicInteger();

        /* 半角1文字分の空白埋めが余った場合に埋める */
        IntStream.range(0, widthList.size())
            .mapToObj(i -> ai.get() < row.size() ? row.get(ai.get()) : "")
            .peek(p -> {
                String space = IntStream.range(0, widthList.get(ai.get()) - LayoutUtil.countFullLength(p))
                        .mapToObj(i -> "  ")
                        .collect(Collectors.joining());
                space += LayoutUtil.countHalfLength(p) % 2 == 1 ? " " : "";
                ret.append(align.format(p, space));
            })
            .forEach(p -> ret.append(ai.getAndIncrement() + 1 < widthList.size() ? "│" : "\r\n"));

        return ret.toString();
    }

    /**
     * 横線作成.
     * @param lineStart 左端罫線取得関数<罫線>
     * @param middle 中間罫線取得関数<文字インデックス, 罫線>
     * @param paramEnd 項目末罫線取得関数<列番号, 罫線>
     * @return 横線文字列
     */
    protected String createBorder(
            Supplier<String> lineStart, Function<Integer, String> middle, Function<Integer, String> paramEnd) {

        AtomicInteger ai = new AtomicInteger();

        return widthList.stream().map(w -> middle.apply(w))
                .reduce(lineStart.get(), (acm, m) -> acm + m + paramEnd.apply(ai.getAndIncrement()), (a, b) -> a + b);
    }

    /**
     * 先頭設定.
     * <P>
     * 項目名リストをレイアウトの先頭部分として設定する。
     *
     * @param header 項目名リスト
     */
    public void setHeader(List<String> header) {
        if (this.header == null) {
            paramList.add(0, header);
        } else {
            paramList.set(0, header);
        }
        this.header = header;

        initWidthList();
    }

    /**
     * 整列設定.
     *
     * @param align 整列
     */
    public void setAlign(LayoutUtil.Align align) {
        this.align = align;
    }

    /**
     * 整列取得.
     *
     * @return 整列
     */
    public LayoutUtil.Align getAlign() {
        return align;
    }
}
