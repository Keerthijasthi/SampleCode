//program: Read a student's marks and print the grade (A/B/C/Fail) using if-else or switch
// I am using if-else because we are dealing with the ranges(eg:90-100) ; Switch can be used when we are checking for the exact values like specific numbers or strings
//need to enter only the numbers not any other things,if apart from numbers entered need to throw like enter a valid numbers.
//based on the marks it should return the grade

//import java.util.Scanner;
//
//public class StudentGrades {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int marks = -1;
//        while (marks < 0 || marks > 100) {
//            System.out.print("Enter student's marks (0-100): ");
//            if (sc.hasNextInt()) {
//                marks = sc.nextInt();
//                if (marks < 0 || marks > 100) {
//                    System.out.println("Please enter marks between 0 and 100.");
//                }
//            } else {
//                System.out.println("Invalid input. Please enter valid numbers only.");
//                sc.next();
//            }
//        }
//        if (marks > 90) {
//            System.out.println("Grade: A");
//        } else if (marks > 70) {
//            System.out.println("Grade: B");
//        } else if (marks >= 50) {
//            System.out.println("Grade: C");
//        } else {
//            System.out.println("Grade: Fail");
//        }
//        sc.close();
//    }
//}

// to get only minimum marks grades only
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGrades {
    enum Subject {
        MATH, SCIENCE, ENGLISH
    }
    enum Grade {
        A, B, C, Fail
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minMark = 101;
        List<Subject> failedSubjects = new ArrayList<>(); // List to track all failed subjects

        for (Subject subject : Subject.values()) {
            int mark = -1;
            while (mark < 0 || mark > 100) {
                System.out.print("Enter " + subject.name().toLowerCase() + " mark (0-100): ");
                if (sc.hasNextInt()) {
                    mark = sc.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Please enter marks between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter valid numbers only.");
                    sc.next();
                }
            }
            minMark = Math.min(minMark, mark);
            if (mark < 50) {
                failedSubjects.add(subject);
            }
        }
        Grade grade;
        StringBuilder reason;
        if (minMark >= 90) {
            grade = Grade.A;
            reason = new StringBuilder(">= 90 in all subjects");
        } else if (minMark >= 75) {
            grade = Grade.B;
            reason = new StringBuilder(">= 75 and <= 90 in all subjects");
        } else if (minMark >= 50) {
            grade = Grade.C;
            reason = new StringBuilder(">= 50 and <= 75 in all subjects");
        } else {
            grade = Grade.Fail;
            reason = new StringBuilder("< 50 in subject");
            if(failedSubjects.size() > 1) {
                reason.append("s ");
            } else
                reason.append(" ");
            for (int i = 0; i < failedSubjects.size(); i++) {
                reason.append(failedSubjects.get(i).name());
                if (i != failedSubjects.size() - 1) {
                    reason.append(", ");
                }
            }
        }
        System.out.println("Student grade is " + grade.name() +
                " - Reason: student has received this grade as they have scored " + reason);
        sc.close();
    }
}
