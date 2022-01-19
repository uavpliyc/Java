package JavaGold;

import java.time.LocalDate;
import java.time.LocalTime;

public class taskBean {

  private String fullString;
  private String halfString;
  private int number;
  private double decimal;
  private LocalDate date;
  private LocalTime time;

  public String getFullString() {
    return this.fullString;
  }

  public void setFullString(String fullString) {
    this.fullString = fullString;
  }

  public String getHalfString() {
    return this.halfString;
  }

  public void setHalfString(String halfString) {
    this.halfString = halfString;
  }

  public int getNumber() {
    return this.number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public double getDecimal() {
    return this.decimal;
  }

  public void setDecimal(double decimal) {
    this.decimal = decimal;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getTime() {
    return this.time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

}