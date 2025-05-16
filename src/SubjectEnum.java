//program:Use Subject enum in a switch to print subject-specific messages.
//2 validations:
//a.User to enter a subject name (like MATH, SCIENCE, ENGLISH) or a number (1, 2, 3) and then shows a welcome message based on the subject.
//b. need to allow the user to keep entering new subjects until they say "no"
import java.util.Scanner;
public class SubjectEnum {
    enum Subject {
        MATH, SCIENCE, ENGLISH
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "yes";
        do {
            System.out.println("Enter a subject name (MATH, SCIENCE, ENGLISH) or a number (1, 2, 3):");
            String input = scanner.nextLine().trim().toUpperCase();
            Subject subject = null;
            if (input.equals("1")) {
                subject = Subject.MATH;
            } else if (input.equals("2")) {
                subject = Subject.SCIENCE;
            } else if (input.equals("3")) {
                subject = Subject.ENGLISH;
            } else {
                try {
                    subject = Subject.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid subject input.");
                    continue;
                }
            }
            switch (subject) {
                case MATH:
                    System.out.println("Welcome to Math class!");
                    break;
                case SCIENCE:
                    System.out.println("Welcome to Science class!");
                    break;
                case ENGLISH:
                    System.out.println("Welcome to English class!");
                    break;
            }
            System.out.println("Do you want to enter another subject? (yes/no):");
            choice = scanner.nextLine().trim().toLowerCase();
        } while (choice.equals("yes"));
        scanner.close();
    }
}