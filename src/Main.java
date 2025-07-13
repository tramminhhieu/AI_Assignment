import java.util.List;
import java.util.Scanner;
import model.Student;
import service.StudentManager;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add student");
            System.out.println("2. Delete student by ID");
            System.out.println("3. Search student by name");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter full name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter GPA: ");
                        double gpa = Double.parseDouble(scanner.nextLine());
                        Student s = new Student(id, name, gpa);
                        manager.addStudent(s);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter ID to delete: ");
                        int delId = Integer.parseInt(scanner.nextLine());
                        if (manager.deleteStudent(delId)) {
                            System.out.println("Student deleted successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter name keyword: ");
                        String keyword = scanner.nextLine();
                        List<Student> found = manager.searchByName(keyword);
                        if (found.isEmpty()) {
                            System.out.println("No student found.");
                        } else {
                            System.out.printf("%-10s %-30s %-5s\n", "ID", "Full Name", "GPA");
                            for (Student st : found) {
                                System.out.println(st);
                            }
                        }
                        break;
                    case 4:
                        manager.displayAll();
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);
        scanner.close();
    }

}
