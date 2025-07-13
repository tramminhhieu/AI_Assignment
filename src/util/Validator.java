package util;

import model.Student;

public class Validator {

    public static boolean isValid(Student s) {
        return s != null
                && s.getStudentId() > 0
                && s.getFullName() != null
                && s.getFullName().length() <= 50
                && s.getGpa() >= 0.0 && s.getGpa() <= 4.0;
    }
}
