package JavaGold;

import gold8.bean.IOBean;

public abstract class AbstractClassC extends AbstractClassA {

  IOBean io;

  public AbstractClassC() {
  }

  protected IOBean convert() {
    return io;
  }

}