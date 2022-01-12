package gold8;

import static java.lang.System.out;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import gold8.bean.SampleBean;
import gold8.data.AsciiChar;
import gold8.data.RandomData;
import gold8.experiment.StopWatch;
import gold8.ruledLineG.ColumnLayout;
import gold8.ruledLineG.LayoutUtil;

/**
 * 動作確認メイン（Gold）.
 * <P>
 * {@link exam.gold8}パッケージ内のプログラムを動作確認する為、<BR>
 * 主要な機能を実行する。
 */
public class TestMain {

    /**
     * Gold SE8メインメソッド.
     * <P>
     * 第1引数<BR>
     * 0：RandomData（第2引数は出力する行数）<BR>
     * 1：SampleBean
     *
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        TestMain own = new TestMain();
        int caseNo = Integer.parseInt(args[0]);

        switch (caseNo) {
        case 0:
            own.randomData(Integer.parseInt(args[1]));
            break;
        case 1:
            own.sampleBean();
            break;
        case 2:
            own.stopWatch();
            break;
        default:
            out.println("引数が不正です。");
            break;
        }
    }

    /**
     * ランダム値選出テスト.
     * <P>
     * 指定された行数分だけ、ランダムに選出した値を列毎に整列して出力する。
     *
     * @param size 行数
     * @see exam.gold8.data.RandomData
     */
    private void randomData(int size) {
        List<String> asciiList = RandomData.getAsciiList(7, size, AsciiChar.BIG_LETTER, AsciiChar.NUMBER);
        List<Integer> intList = RandomData.getIntList(100, 1000000, 100, size);
        List<Double> doubleList = RandomData.getDoubleList(0, 100, 0.01, size);
        List<LocalDate> dateList = RandomData.getDateList(LocalDate.now().minusYears(100), LocalDate.now(), 1, size);
        List<LocalTime> timeList = RandomData.getTimeList(LocalTime.MIN, LocalTime.MAX, Duration.ofSeconds(1), size);
        List<List<String>> paramList = LayoutUtil.parseList(asciiList, intList, doubleList, dateList, timeList);
        new ColumnLayout(paramList).display();
    }

    /**
     * 実装例Beanテスト.
     * <P>
     * ConvertibleBeanクラスを継承したBeanの実装例に対して、データ設定時の変換を確認する。
     *
     * @see exam.gold8.bean.SampleBean
     */
    private void sampleBean() {
        SampleBean bean = new SampleBean();
        List<String> list =  Arrays.asList(new String[] {"1", "aaa", "20211204"});
        IntStream.range(0, list.size()).peek(i -> bean.set(i, list.get(i))).forEach(i -> out.println(bean.get(i)));
        out.println(bean.getSeq());
        out.println(bean.getName());
        out.println(bean.getBirthDay());
    }

    /**
     * ストップウォッチテスト.
     * <P>
     * 幾つかの単純な処理について、その処理速度の測定結果を一覧表にして出力する。
     */
    private void stopWatch() {
        out.println("数十秒ほどお待ち下さい。");
        Map<String, Runnable> jobs = new LinkedHashMap<>();

        int[] intArr1 = new int[1];
        jobs.put("int型のインクリメント", () -> intArr1[0]++);

        int[] intArr2 = new int[1];
        jobs.put("int型の加算代入", () -> intArr2[0] += 1);

        Integer[] integerArr = new Integer[1];
        integerArr[0] = 0;
        Integer integer = new Integer(1);
        jobs.put("Integer型の加算", () -> Math.addExact(integerArr[0], integer));

        String[] strArr = new String[1];
        jobs.put("String型の連結", () -> strArr[0] = strArr[0] + "a");

        StringBuilder sb = new StringBuilder();
        jobs.put("StringBuilder型の連結", () -> sb.append("b"));

        /* 処理時間が1000ミリ秒（1秒）を超えるか、1億回ループするまで実行した結果を出力 */
        new StopWatch(1000, 100000000).measureLayout(jobs).display();
    }
}
