import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ランダム値選出.
 * <P>
 * ランダムなデータを生成するstaticメソッドを実装している。
 */
public class RandomData {

    /**
     * 添え字取得（簡易）.
     * <P>
     * 0から最大値までの整数から、ランダムに選出した数値を返す。
     *
     * @param max 最大値
     * @return 添え字
     */
    public static int getIndex(int max) {
        return getIndex(0, max, 1);
    }

    /**
     * 添え字取得.
     * <P>
     * 最小値から最大値までの範囲を間隔毎に等分し、ランダムに選出した数値を返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @return 添え字
     */
    public static int getIndex(double min, double max, double interval) {
        double unit = 1 / ((Math.abs(max - min) + 1) / Math.abs(interval));
        return (int) Math.floor(Math.random() / unit);
    }

    /**
     * リスト生成.
     * <P>
     * 指定されたサイズのリストを生成し、各要素にサプライヤから取得された値を格納して返す。
     *
     * @param spl サプライヤ
     * @param size サイズ
     * @return リスト
     */
    public static <E> List<E> createList(Supplier<E> spl, int size) {
        LinkedList<E> list = new LinkedList<>();
        IntStream.range(0, size).forEach(i -> list.add(spl.get()));
        return new ArrayList<>(list);
    }

    /**
     * 整数値取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した整数値を返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @return ランダム整数値
     */
    public static int getInt(int min, int max, int interval) {
        return min + getIndex(min, max, interval) * interval;
    }

    /**
     * 整数値リスト取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した整数値を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @param size サイズ
     * @return ランダム整数値リスト
     */
    public static List<Integer> getIntList(int min, int max, int interval, int size) {
        return createList(() -> getInt(min, max, interval), size);
    }

    /**
     * 長整数値取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した長整数値を返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @return ランダム長整数値
     */
    public static long getLong(long min, long max, long interval) {
        return min + getIndex(min, max, interval) * interval;
    }

    /**
     * 長整数値リスト取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した長整数値を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @param size サイズ
     * @return ランダム長整数値リスト
     */
    public static List<Long> getLongList(long min, long max, long interval, int size) {
        return createList(() -> getLong(min, max, interval), size);
    }

    /**
     * 小数値取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した小数値を返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @return ランダム小数値
     */
    public static double getDouble(double min, double max, double interval) {
        return min + getIndex(min, max, interval) * interval;
    }

    /**
     * 小数値リスト取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した小数値を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @param size サイズ
     * @return ランダム小数値リスト
     */
    public static List<Double> getDoubleList(double min, double max, double interval, int size) {
        return createList(() -> getDouble(min, max, interval), size);
    }

    /**
     * 真偽値取得.
     * <P>
     * trueとfalseのどちらかをランダムに返す。
     *
     * @return ランダム真偽値
     */
    public static boolean getBoolean() {
        return getIndex(1) == 0;
    }

    /**
     * 真偽値リスト取得.
     * <P>
     * ランダムに選出した真偽値を格納した、指定されたサイズのリストを返す。
     *
     * @param size サイズ
     * @return ランダム真偽値リスト
     */
    public static List<Boolean> getBooleanList(int size) {
        return createList(() -> getBoolean(), size);
    }

    /**
     * 日付取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した日付を返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @return ランダム日付
     */
    public static LocalDate getDate(LocalDate min, LocalDate max, int interval) {
        return min.plusDays(getInt(0, Period.between(min, max).getDays() + 1, interval));
    }

    /**
     * 日付リスト取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した日付を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @param size サイズ
     * @return ランダム日付リスト
     */
    public static List<LocalDate> getDateList(LocalDate min, LocalDate max, int interval, int size) {
        return createList(() -> getDate(min, max, interval), size);
    }

    /**
     * 時刻取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した時刻を返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @return ランダム時刻
     */
    public static LocalTime getTime(LocalTime min, LocalTime max, Duration interval) {
        Duration range = Duration.between(min, max);
        int nano = 0;
        int nanoInterval = interval.getNano();
        long secondClose = 0;

        /* ナノ秒の有無に応じて含める最大値を秒かナノ秒か分ける。 */
        if (0 < nanoInterval) {
            nano = getInt(0, range.getNano() + 1, nanoInterval);
        } else {
            secondClose = 1;
        }

        long second = getLong(0, range.getSeconds() + secondClose, interval.getSeconds());

        return min.plusSeconds(second).plusNanos(nano);
    }

    /**
     * 時刻リスト取得.
     * <P>
     * 最小値から最大値の範囲内且つ、指定された間隔毎の値からランダムに選出した時刻を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param min 最小値
     * @param max 最大値
     * @param interval 間隔
     * @param size サイズ
     * @return ランダム時刻リスト
     */
    public static List<LocalTime> getTimeList(LocalTime min, LocalTime max, Duration interval, int size) {
        return createList(() -> getTime(min, max, interval), size);
    }

    /**
     * 要素取得.
     * <P>
     * 渡されたコレクションからランダムに選出した要素を返す。
     *
     * @param col コレクション
     * @return ランダム要素
     */
    public static <E> E getElement(Collection<E> col) {
        return new ArrayList<>(col).get(getIndex(0, col.size() - 1, 1));
    }

    /**
     * 要素リスト取得.
     * <P>
     * 渡されたコレクションからランダムに選出した要素を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param col コレクション
     * @param size サイズ
     * @return ランダム要素リスト
     */
    public static <E> List<E> getElementList(Collection<E> col, int size) {
        return createList(() -> getElement(col), size);
    }

    /**
     * ASCII文字列取得.
     * <P>
     * AsciiChar列挙子の範囲内からランダムに選出し、指定された文字列長の文字列を返す。
     *
     * @param length 文字列長
     * @param asciiChars AsciiChar列挙子
     * @return ASCII文字列
     */
    // public static String getAscii(int length, AsciiChar... asciiChars) {
    //     return IntStream.range(0, length)
    //             .mapToObj(i -> getElement(asciiChars[getIndex(asciiChars.length)].getCharList()))
    //             .reduce("", (acm, ch) -> acm + ch.toString(), (a, b) -> a + b);
    // }

    /**
     * ASCII文字列リスト取得.
     * <P>
     * AsciiChar列挙子の範囲内からランダムに選出し、指定された文字列長の文字列を格納した、<BR>
     * 指定されたサイズのリストを返す。
     *
     * @param length 文字列長
     * @param size サイズ
     * @param asciiChars AsciiChar列挙子
     * @return ASCII文字列リスト
     */
    // public static List<String> getAsciiList(int length, int size, AsciiChar... asciiChars) {
    //     /* 要素毎に文字リストを生成する時間を省略する為、生成済みのリストから取得する。 */
    //     List<List<Character>> asciiCharsList = Arrays.asList(asciiChars).stream()
    //             .map(ac -> ac.getCharList())
    //             .collect(Collectors.toList());

    //     Supplier<String> spl = () -> IntStream.range(0, length)
    //             .mapToObj(i -> getElement(getElement(asciiCharsList)))
    //             .reduce("", (acm, ch) -> acm + ch.toString(), (a, b) -> a + b);

    //     return createList(spl, size);
    // }
}
