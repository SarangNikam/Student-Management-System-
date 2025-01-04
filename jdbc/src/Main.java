import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    StudentDAO studentDAO = new StudentDAO();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("\nStudent Management System");
      System.out.println("1. Add Student");
      System.out.println("2. View All Students");
      System.out.println("3. Update Student");
      System.out.println("4. Delete Student");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");

      try {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
          case 1:
            studentDAO.addStudent();
            break;
          case 2:
            studentDAO.viewAllStudents();
            break;
          case 3:
            studentDAO.updateStudent();
            break;
          case 4:
            studentDAO.deleteStudent();
            break;
          case 5:
            System.out.println("Exiting...");
            running = false;
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Clear the invalid input
      }
    }

    scanner.close();
  }
}
