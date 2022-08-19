import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
  public static void main(String[] args) {
    String sql = "SELECT name FROM department";
    String sql2 = "UPDATE department SET name='tanaka' WHERE id='1'";
    try (Connection con = DbConnector.getConnect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {
          if (rs != null) System.out.println("rs != null!");
          if (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
          }
          // execute：SELECT以外false返す
          boolean result1 = stmt.execute(sql);
          // executeUpdate：なければ0返す
          int result2 = stmt.executeUpdate(sql2);
          // executeQuery：なければ空のResultSetを返す
          ResultSet result3 = stmt.executeQuery(sql);
          System.out.println(result1);
          System.out.println(result2);
          System.out.println(result3);
          // getMetaData
          System.out.println(rs.getMetaData());
        } catch (SQLException e) {
          e.printStackTrace();
        }
  }
}