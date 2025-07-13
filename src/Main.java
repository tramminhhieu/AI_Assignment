import java.util.Scanner;
import service.StudentManager;
import menu.StudentMenuHandler;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            StudentMenuHandler.showMenu();
            choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        StudentMenuHandler.handleAddStudent(manager, sc);
                        break;
                    case 2:
                        StudentMenuHandler.handleDeleteStudent(manager, sc);
                        break;
                    case 3:
                        StudentMenuHandler.handleSearchStudent(manager, sc);
                        break;
                    case 4:
                        manager.displayAll();
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);
    }

}
