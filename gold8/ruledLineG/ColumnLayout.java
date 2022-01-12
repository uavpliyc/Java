package gold8.ruledLineG;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 列割当表示.
 * <P>
 * 項目値を列毎に区切って表示する。
 */
public class ColumnLayout extends SimpleLayout {

    /**
     * ColumnLayoutコンストラクタ.
     *
     * @param columnList 列リスト
     */
    public ColumnLayout(List<List<String>> columnList) {
        super(columnList, LayoutUtil::countHalfLength);
    }

    @Override
    protected String createHead() {
        return "";
    }

    @Override
    protected String createBody() {
        return getParams().stream().map(p -> createRow(p)).collect(Collectors.joining());
    }

    @Override
    protected String createRow(List<String> row) {
        StringBuilder ret = new StringBuilder();
        AtomicInteger ai = new AtomicInteger();

        /* 半角文字で空白埋めする */
        IntStream.range(0, getWidthList().size())
            .mapToObj(i -> ai.get() < row.size() ? row.get(ai.get()) : "")
            .peek(p -> {
                String space = IntStream.range(0, getWidthList().get(ai.get()) - LayoutUtil.countHalfLength(p))
                        .mapToObj(i -> " ")
                        .collect(Collectors.joining());
                ret.append(getAlign().format(p, space));
            })
            .forEach(p -> ret.append(ai.getAndIncrement() + 1 < getWidthList().size() ? "│" : "\r\n"));

        return ret.toString();
    }
}
