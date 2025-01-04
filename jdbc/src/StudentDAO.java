import java.sql.*;
import java.util.Scanner;

public class StudentDAO {
  private Connection conn;

  public StudentDAO() {
    try {
      conn = App.getConnection();
      if (conn == null) {
        throw new SQLException("Failed to establish a database connection.");
      }
    } catch (SQLException e) {
      System.err.println("Database connection error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void addStudent() {
    String query = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
    try (PreparedStatement pst = conn.prepareStatement(query);
         Scanner scanner = new Scanner(System.in)) {

      System.out.print("Enter Student Name: ");
      String name = scanner.nextLine().trim();
      if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

      System.out.print("Enter Student Age: ");
      int age = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      if (age <= 0) throw new IllegalArgumentException("Age must be positive.");

      System.out.print("Enter Student Course: ");
      String course = scanner.nextLine().trim();
      if (course.isEmpty()) throw new IllegalArgumentException("Course cannot be empty.");

      pst.setString(1, name);
      pst.setInt(2, age);
      pst.setString(3, course);

      int result = pst.executeUpdate();
      System.out.println(result > 0 ? "Student added successfully." : "Error adding student.");
    } catch (SQLException e) {
      System.err.println("Database error: " + e.getMessage());
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.err.println("Input error: " + e.getMessage());
    }
  }

  public void viewAllStudents() {
    String query = "SELECT * FROM students";
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

      while (rs.next()) {
        System.out.println("ID: " + rs.getInt("id") +
            ", Name: " + rs.getString("name") +
            ", Age: " + rs.getInt("age") +
            ", Course: " + rs.getString("course"));
      }
    } catch (SQLException e) {
      System.err.println("Database error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void updateStudent() {
    String query = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";
    try (PreparedStatement pst = conn.prepareStatement(query);
         Scanner scanner = new Scanner(System.in)) {

      System.out.print("Enter Student ID to update: ");
      int id = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      System.out.print("Enter new Name: ");
      String name = scanner.nextLine().trim();
      if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

      System.out.print("Enter new Age: ");
      int age = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      if (age <= 0) throw new IllegalArgumentException("Age must be positive.");

      System.out.print("Enter new Course: ");
      String course = scanner.nextLine().trim();
      if (course.isEmpty()) throw new IllegalArgumentException("Course cannot be empty.");

      pst.setString(1, name);
      pst.setInt(2, age);
      pst.setString(3, course);
      pst.setInt(4, id);

      int result = pst.executeUpdate();
      System.out.println(result > 0 ? "Student updated successfully." : "Error updating student.");
    } catch (SQLException e) {
      System.err.println("Database error: " + e.getMessage());
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.err.println("Input error: " + e.getMessage());
    }
  }

  public void deleteStudent() {
    String query = "DELETE FROM students WHERE id = ?";
    try (PreparedStatement pst = conn.prepareStatement(query);
         Scanner scanner = new Scanner(System.in)) {

      System.out.print("Enter Student ID to delete: ");
      int id = scanner.nextInt();

      pst.setInt(1, id);

      int result = pst.executeUpdate();
      System.out.println(result > 0 ? "Student deleted successfully." : "Error deleting student.");
    } catch (SQLException e) {
      System.err.println("Database error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
