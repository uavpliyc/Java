package gold8.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * アスキー文字.
 * <P>
 * Character型の文字を種類毎に取得する列挙子を定義している。
 */
public enum AsciiChar {
    /** タブ（水平タブ、垂直タブ）. */
    TAB(new Code(9), new Code(11)),
    /** 改行（CR、LF）. */
    NEW_LINE(new Code(10), new Code(13)),
    /** スペース. */
    SPACE(new Code(32)),
    /** 数字（0～9）. */
    NUMBER(new Code(48, 57)),
    /** 英大字（A～Z） */
    BIG_LETTER(new Code(65, 90)),
    /** 英小字（a～z） */
    SMALL_LETTER(new Code(97, 122)),
    /** 記号. */
    SYMBOL(new Code(33, 47), new Code(58, 64), new Code(91, 96), new Code(123, 126)),
    /** その他. */
    OTHER(new Code(0, 8), new Code(12), new Code(14, 31), new Code(127));

    /** コード値リスト. */
    private List<Code> codeList;

    /**
     * AsciiCharコンストラクタ.
     *
     * @param codeArray コード値
     */
    AsciiChar(Code... codeArray) {
        this.codeList = Arrays.asList(codeArray) ;
    }

    /**
     * 文字リスト取得.
     * <P>
     * 列挙子に対応した種類の文字を格納したリストを返す。
     *
     * @return 文字リスト
     */
    public List<Character> getCharList() {
        return IntStream.range(0, codeList.size())
                .mapToObj(i -> IntStream.rangeClosed(codeList.get(i).getFirst(), codeList.get(i).getLast())
                        // .mapToObj(charCode -> new Character((char) charCode))
                        .mapToObj(charCode -> Character.valueOf((char) charCode))
                        .collect(Collectors.toList()))
                .flatMap(charList -> charList.stream())
                .collect(Collectors.toList());
    }

    /**
     * 有無確認.
     * <P>
     * 判定対象文字が列挙子に対応した文字に含まれるか判定する。
     *
     * @param ch 判定対象文字
     * @return 判定結果（true：含まれる）
     */
    public boolean contains(Character ch) {
        return 0 < codeList.stream()
                .filter(code -> code.getFirst() <= (int) ch && (int) ch <= code.getLast())
                .count();
    }

    /**
     * 結合文字リスト取得.
     * <P>
     * AsciiChar列挙子で指定されたCharacter型の文字を全て格納したリストを返す。<BR>
     * このリスト内で文字は自然順に整列されている。
     *
     * @param asciiChars AsciiChar列挙子
     * @return
     */
    public static List<Character> getJoinedList(AsciiChar... asciiChars) {
        return Arrays.asList(asciiChars).stream()
                .map(asciiChar -> asciiChar.getCharList())
                .flatMap(charList -> charList.stream())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * 全文字取得.
     * <P>
     * Character型の文字を全て格納したリストを返す。<BR>
     * このリスト内で文字は自然順に整列されている。
     *
     * @return 全文字リスト
     */
    public static List<Character> getAll() {
        return Arrays.asList(values()).stream()
                .map(asciiChar -> asciiChar.getCharList())
                .flatMap(charList -> charList.stream())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * コード値.
     * <P>
     * AsciiCharクラス内で使用するASCII文字のコード値を格納する。
     */
    private static class Code {
        private int first;
        private int last;

        public Code(int code) {
            this(code, code);
        }

        public Code(int first , int last) {
            this.first = first;
            this.last = last;
        }

        public int getFirst() {
            return first;
        }

        public int getLast() {
            return last;
        }
    }
}
