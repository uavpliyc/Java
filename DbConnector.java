import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
  public static Connection getConnect() throws SQLException {
    String url = "jdbc:mysql://localhost/golddb";
    String user = "root";
    String passwd = "test";
    Connection con = DriverManager.getConnection(url, user, passwd);
    return con;
  }
}