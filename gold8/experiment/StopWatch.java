package gold8.experiment;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import gold8.ruledLineG.GridLayout;
import gold8.ruledLineG.Layout;
import gold8.ruledLineG.LayoutUtil;

/**
 * ストップウォッチ.
 * <P>
 * 処理速度を計測し、性能を調査する機能を提供する。
 */
public class StopWatch {

    /** 限界時間（ミリ秒）. */
    private final long limitTime;
    /** 最大ループ回数. */
    private final int maxLoop;
    /** 最小ループ回数. */
    private final int minLoop;
    /** 試行回数. */
    private final int trials;

    /**
     * StopWatchコンストラクタ.
     * <P>
     * 初期値の最大ループ回数、最小ループ回数、試行回数に加え、<BR>
     * 限界時間を1000ミリ秒（1秒）として初期化する。
     *
     * @see #StopWatch(long)
     */
    public StopWatch() {
        this(1000);
    }

    /**
     * StopWatchコンストラクタ.
     * <P>
     * 初期値の最小ループ回数、試行回数に加え、<BR>
     * 最大ループ回数を10000回として初期化する。
     *
     * @param limitTime 限界時間（ミリ秒）
     * @see #StopWatch(long, int)
     */
    public StopWatch(long limitTime) {
        this(limitTime, 10000);
    }

    /**
     * StopWatchコンストラクタ.
     * <P>
     * 初期値の試行回数に加え、最小ループ回数を100回として初期化する。
     *
     * @param limitTime 限界時間（ミリ秒）
     * @param maxLoop 最大ループ回数
     * @see #StopWatch(long, int, int)
     */
    public StopWatch(long limitTime, int maxLoop) {
        this(limitTime, maxLoop, 100);
    }

    /**
     * StopWatchコンストラクタ.
     * <P>
     * 試行回数を3回として初期化する。
     *
     * @param limitTime 限界時間（ミリ秒）
     * @param maxLoop 最大ループ回数
     * @param trials 試行回数
     * @see #StopWatch(long, int, int, int)
     */
    public StopWatch(long limitTime, int maxLoop, int minLoop) {
        this(limitTime, maxLoop, minLoop, 3);
    }

    /**
     * StopWatchコンストラクタ.
     * <P>
     * 各設定値を任意の値で初期化する。
     *
     * @param limitTime 限界時間（ミリ秒）
     * @param maxLoop 最大ループ回数
     * @param minLoop 最小ループ回数
     * @param trials 試行回数
     */
    public StopWatch(long limitTime, int maxLoop, int minLoop, int trials) {
        this.limitTime = limitTime;
        this.maxLoop = maxLoop;
        this.minLoop = minLoop;
        this.trials = trials;
    }

    /**
     * 計測.
     * <P>
     * 計測対象ジョブを指定されたループ回数だけ実行し、<BR>
     * 完了までの時間を計測して返す。
     *
     * @param loopCount ループ回数
     * @param job 計測対象ジョブ
     * @return 計測結果（ミリ秒）
     */
    public long measure(int loopCount, Runnable job) {
        assert 0 < loopCount;
        Instant start = Instant.now();
        IntStream.range(0, loopCount).forEach(i -> job.run());
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    /**
     * 試行計測.
     * <P>
     * 計測のループ処理を予め設定された回数だけ試行し、測定結果の平均を返す。<BR>
     * 試行回数が多いほど測定に時間が掛かるが、精度の高い結果を得られる。
     *
     * @param loopCount ループ回数
     * @param job 計測対象ジョブ
     * @return 計測結果（ミリ秒）
     * @see #StopWatch(long, int, int)
     * @see #measure(int, Runnable)
     */
    public long measureTrials(int loopCount, Runnable job) {
        return (long) IntStream.range(0, trials)
                .mapToDouble(i -> measure(loopCount, job))
                .average().getAsDouble();
    }

    /**
     * 限界計測.
     * <P>
     * ループ回数が最大ループ回数に達するか、<BR>
     * 計測結果が限界時間を超えるまでループ回数を10倍しながら繰り返し、<BR>
     * ループ回数毎の計測結果を返す。
     *
     * @param job 計測対象ジョブ
     * @return 計測結果マップ＜ループ回数, 計測結果＞
     * @see #measureTrials(int, Runnable)
     */
    public Map<Integer, Long> measureToMax(Runnable job) {
        assert 0 < limitTime && limitTime < 1000000 : "限界時間（ミリ秒）=" + limitTime;
        assert 0 < maxLoop && 0 < minLoop : "最大ループ回数=" + maxLoop + ".最小ループ回数=" + minLoop;

        Map<Integer, Long> resultMap = new HashMap<>();
        for (int i = 0, loop = 0; loop < maxLoop && resultMap.getOrDefault(loop, 0L) < limitTime; i++) {
            loop = Math.min(minLoop * (int) Math.pow(10, i), maxLoop);
            resultMap.put(loop, measureTrials(loop, job));
        }
        return resultMap;
    }

    /**
     * 一覧計測（可変長設定）.
     * <P>
     * ジョブそれぞれに対してループ回数又は時間の限界まで計測し、<BR>
     * ループ回数毎の計測結果リストを返す。<BR>
     * 計測結果リストの並び順はジョブの設定順と一致し、<BR>
     * 他のジョブよりも先に限界時間を超えたものの測定結果にはnullが設定される。
     *
     * @param jobs 計測対象ジョブ（可変長）
     * @return 計測結果マップ＜ループ回数, 計測結果リスト＞
     * @see #measureToMax(Runnable)
     */
    public Map<Integer, List<Optional<Long>>> measureTable(Runnable... jobs) {
        return measureTable(Arrays.asList(jobs));
    }

    /**
     * 一覧計測（リスト設定）.
     * <P>
     * リスト内の全ジョブに対してループ回数又は時間の限界まで計測し、<BR>
     * ループ回数毎の計測結果リストを返す。<BR>
     * 計測結果リストの並び順はジョブの設定順と一致し、<BR>
     * 他のジョブよりも先に限界時間を超えたものの測定結果にはnullが設定される。
     *
     * @param jobs 計測対象ジョブリスト
     * @return 計測結果マップ＜ループ回数, 計測結果リスト＞
     * @see #measureTable(Runnable...)
     */
    public Map<Integer, List<Optional<Long>>> measureTable(List<Runnable> jobs) {
        assert 0 < jobs.size();

        /* 各ジョブの計測結果を取得 */
        List<Map<Integer, Long>> jobResults = jobs.stream()
                .map(r -> measureToMax(r))
                .collect(Collectors.toList());

        /* 計測された全ループ回数を取得 */
        Set<Integer> allLoops = jobResults.stream()
                .flatMap(m -> m.keySet().stream())
                .collect(Collectors.toSet());

        /* 計測結果マップを作成 */
        Map<Integer, List<Optional<Long>>> resultMap = new TreeMap<>();
        allLoops.stream().forEach(k -> resultMap.put(k, jobResults.stream()
                .map(m -> Optional.ofNullable(m.getOrDefault(k, null)))
                .collect(Collectors.toList())));

        return resultMap;
    }

    /**
     * 計測結果一覧表作成.
     * <P>
     * マップ内の全ジョブに対してループ回数又は時間の限界まで計測し、<BR>
     * ループ回数毎の計測結果を一覧表に纏めて返す。<BR>
     * 一覧表の項目名には各ジョブのジョブ名が設定される。<BR>
     * 限界時間を超えた後の測定結果には「-」が設定される。<BR>
     * ジョブを設定した順に表示する場合は{@link java.util.LinkedHashMap}の使用を推奨する。
     *
     * @param jobs 計測対象ジョブマップ＜ジョブ名, ジョブ＞
     * @return 計測結果一覧表
     * @see #measureTable(List)
     */
    public Layout measureLayout(Map<String, Runnable> jobs) {
        assert 0 < jobs.size();

        /* 一覧表のレコード部分を作成 */
        Map<Integer, List<Optional<Long>>> recordMap = measureTable(new ArrayList<>(jobs.values()));
        List<List<String>> recordList = recordMap.entrySet().stream()
                .map(e -> editRecord(e))
                .collect(Collectors.toList());

        /* 一覧表の全行を作成 */
        List<List<String>> rowList = new ArrayList<>();
        rowList.add(editTitles(jobs.keySet()));
        rowList.addAll(recordList);

        /* 計測結果一覧表を作成 */
        GridLayout resultLayout = new GridLayout(rowList, 4, 7);
        resultLayout.setAlign(LayoutUtil.Align.RIGHT);

        return resultLayout;
    }

    /**
     * 項目名編集.
     * <P>
     * @param titles 項目名コレクション
     * @return 項目名リスト
     */
    protected List<String> editTitles(Collection<String> titles) {
        List<String> title = new ArrayList<>();
        title.add("ループ回数");
        title.addAll(titles);
        return title;
    }

    /**
     * レコード編集.
     * <P>
     * 1レコード分の測定結果の各項目に対して単位や空欄時の値を設定し、<BR>
     * 一覧表へ出力可能な文字列リストを編集して返す。
     *
     * @param record 計測結果レコード＜ループ回数, 計測結果リスト＞
     * @return レコード文字列リスト
     * @see #measureTable(List)
     */
    protected List<String> editRecord(Map.Entry<Integer, List<Optional<Long>>> record) {
        List<String> row = record.getValue().stream()
                .map(o -> o.isPresent() ? o.get() + " ms" : "-")
                .collect(Collectors.toList());

        row.add(0, record.getKey() + " 回");

        return row;
    }
}
