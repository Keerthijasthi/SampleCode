import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeSorter {

    // Enum for subjects
    enum Subject {
        MATH, SCIENCE, ENGLISH, HISTORY
    }
    // Student class
    static class Student {
        String name;
        Subject favoriteSubject;
        Student(String name, Subject favoriteSubject) {
            this.name = name;
            this.favoriteSubject = favoriteSubject;
        }
        @Override
        public String toString() {
            return name + " (" + favoriteSubject + ")";
        }
    }
    public static void main(String[] args) {
        // Create and sort dummy grades
        int[] grades = {85, 72, 90, 66, 100, 77};
        System.out.println("Original Grades: " + Arrays.toString(grades));
        Arrays.sort(grades);
        System.out.println("Sorted Grades: " + Arrays.toString(grades));
        // Create array of students
        Student[] students = {
                new Student("Alice", Subject.MATH),
                new Student("Bob", Subject.SCIENCE),
                new Student("Charlie", Subject.ENGLISH),
                new Student("Diana", Subject.MATH),
                new Student("Eve", Subject.HISTORY),
                new Student("Frank", Subject.SCIENCE)
        };
        // Group students by subject using an array (Subject.ordinal() as index)
        List<Student>[] groupedBySubject = new List[Subject.values().length];
        for (int i = 0; i < groupedBySubject.length; i++) {
            groupedBySubject[i] = new ArrayList<>();
        }
        for (Student student : students) {
            groupedBySubject[student.favoriteSubject.ordinal()].add(student);
        }
        // Print grouped students
        System.out.println("\nStudents grouped by favorite subject:");
        for (int i = 0; i < groupedBySubject.length; i++) {
            System.out.println(Subject.values()[i] + ": " + groupedBySubject[i]);
        }
    }
}
