import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
  public static void main(String[] args) {
    String sql = "SELECT name FROM department";
    try (Connection con = DbConnector.getConnect();
        Statement stmt = con.createStatement();
        // boolean result1 = stmt.execute(sql);
        // int result2 = stmt.executeUpdate(sql);
        ResultSet rs = stmt.executeQuery(sql)
        ) {
          if (rs != null) System.out.println("rs != null!");
          if (rs.next()) {
            System.out.println(rs.getString(1));
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
  }
}