package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import model.Student;
import util.Validator;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws Exception {
        if (students.size() >= 100) {
            throw new Exception("Student list is full.");
        }

        for (Student st : students) {
            if (st.getStudentId() == s.getStudentId()) {
                throw new Exception("Duplicate student ID.");
            }
        }

        if (!Validator.isValid(s)) {
            throw new Exception("Invalid student information.");
        }

        students.add(s);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }

    public List<Student> searchByName(String keyword) {
        String lower = keyword.toLowerCase(Locale.ROOT);
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(lower)) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.printf("%-10s %-30s %-5s\n", "ID", "Full Name", "GPA");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
