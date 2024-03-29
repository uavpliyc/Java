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
            // 列インデックス(1スタート)を引数に指定
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            // moveToInsertRow：DBに反映させるため移動
            rs.moveToInsertRow();
            // insertRow：DBに反映
            rs.insertRow();
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