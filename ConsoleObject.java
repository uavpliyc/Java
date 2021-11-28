import java.io.Console;
import java.io.PrintWriter;

public class ConsoleObject {
  public static void main(String[] args) {
    Console con = System.console();
    PrintWriter pw = con.writer();
    while (true) {
      String str = con.readLine();
      if (str.equals("")) {
        break;
      }
      pw.append("入力：" + str);
      pw.flush();
    }

    // readPassword：入力がコンソール上に表示されない(入力中)
    char[] pass = con.readPassword();
    for (char c : pass) {
      System.out.println(c);
    }
  }
}