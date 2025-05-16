//program: Read a student's marks and print the grade (A/B/C/Fail) using if-else or switch
// i am using if-else because we are dealing with the ranges(eg:90-100) ; Switch can be used when we are checking for the exact values like specific numbers or strings
//need to enter only the numbers not any other things,if apart from numbers entered need to throw like enter a valid numbers.
//based on the marks it should return the grade
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int marks = -1;
        while (marks < 0 || marks > 100) {
            System.out.print("Enter student's marks (0-100): ");
            if (sc.hasNextInt()) {
                marks = sc.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("Please enter marks between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter valid numbers only.");
                sc.next();
            }
        }
        if (marks > 90) {
            System.out.println("Grade: A");
        } else if (marks > 70) {
            System.out.println("Grade: B");
        } else if (marks >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }
        sc.close();
    }
}
