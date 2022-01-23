package JavaGold;

import java.util.Calendar;

public interface DayOffResolver {

  /**
   * 指定された日付が休日か判定します。
   *
   * @param cal  日付
   * @return 日付が休日の場合は {@code true}
   */
  boolean isDayOff(Calendar cal);

}