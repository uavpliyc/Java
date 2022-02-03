package JavaGold;

import java.io.Console;
import java.io.PrintWriter;

public class talkApp {
  public static void main(String[] args) {

    Console con = System.console();
    PrintWriter pw = con.writer();
    while (true) {
      // readLineメソッド：Stringを返す
      String str = con.readLine();
      // endと入力されたら抜ける
      if (str.equals("end")) {
        break;
      }
      pw.append("入力：" + str);
      pw.flush();
    }

  }
}