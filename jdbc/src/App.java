import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
  private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
  private static final String USER = "root";
  private static final String PASSWORD = "Pass@123";

  public static Connection getConnection() throws SQLException {
    Connection conn;
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Database connection established successfully.");
    } catch (SQLException e) {
      System.err.println("Failed to connect to the database. Check the URL, username, or password.");
      throw e; // Rethrow the exception to inform the caller of the failure.
    }
    return conn;
  }
}
