package gold8.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 実装例Bean.
 * <P>
 * ConvertibleBeanクラスを継承したBeanの実装例であり、特に用途は無い。<BR>
 * @see ConvertibleBean
 */
public class SampleBean extends ConvertibleBean {

    /** シーケンス番号. */
    private int seq;
    /** 氏名. */
    private String name;
    /** 生年月日. */
    private LocalDate birthDay;

    /**
     * SampleBeanコンストラクタ.
     */
    public SampleBean() {
        super(new ConverterList());
        addField(s -> seq = Integer.valueOf(s), () -> String.valueOf(seq));
        addField(s -> name = s, () -> name);
        addField(s -> birthDay = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE),
                () -> birthDay.format(DateTimeFormatter.BASIC_ISO_DATE));
    }

    /**
     * シーケンス番号設定.
     *
     * @param seq シーケンス番号
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * シーケンス番号取得.
     *
     * @return シーケンス番号
     */
    public int getSeq() {
        return seq;
    }

    /**
     * 氏名設定.
     *
     * @param name 氏名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 氏名取得.
     *
     * @return 氏名
     */
    public String getName() {
        return name;
    }

    /**
     * 生年月日設定.
     *
     * @param birthDay 生年月日
     */
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * 生年月日取得.
     *
     * @return 生年月日
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }
}
