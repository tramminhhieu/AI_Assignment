package menu;

import java.util.List;
import java.util.Scanner;
import model.Student;
import service.StudentManager;

public class StudentMenuHandler {

    public static void handleAddStudent(StudentManager manager, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter full name: ");
        String name = sc.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = Double.parseDouble(sc.nextLine());

        Student s = new Student(id, name, gpa);
        manager.addStudent(s);
        System.out.println("Student added.");
    }

    public static void handleDeleteStudent(StudentManager manager, Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int delId = Integer.parseInt(sc.nextLine());
        if (manager.deleteStudent(delId)) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void handleSearchStudent(StudentManager manager, Scanner sc) {
        System.out.print("Enter name keyword: ");
        String keyword = sc.nextLine();
        List<Student> found = manager.searchByName(keyword);
        if (found.isEmpty()) {
            System.out.println("No student found.");
        } else {
            System.out.printf("%-10s %-30s %-5s\n", "ID", "Full Name", "GPA");
            for (Student st : found) {
                System.out.println(st);
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add student");
        System.out.println("2. Delete student by ID");
        System.out.println("3. Search student by name");
        System.out.println("4. Display all students");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }
}
