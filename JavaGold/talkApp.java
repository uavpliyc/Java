package JavaGold;

import java.io.Console;
import java.io.PrintWriter;

// 課題6-1：コンソールからの入力を読み込み、対話型プログラムを作成する
public class talkApp extends OptionClass {
  public static void main(String[] args) {

    Console con = System.console();
    PrintWriter pw = con.writer();
    while (true) {
      // readLineメソッド：Stringを返す
      String str = con.readLine("入力：");
      // endと入力されたら抜ける
      if (str.equals(FINISH)) {
        break;
      }
      if (FINISH.equals(str)) {
        break;
      }
      // 指定文字を追加
      pw.append(str + '\n');
      // ファイルやコンソールに書き込む
      pw.flush();
    }

  }
}