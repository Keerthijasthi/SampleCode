import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class DivisionWithTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numerator: ");
        int num = sc.nextInt();

        System.out.print("Enter the denominator: ");
        int den = sc.nextInt();

        try {
            int result = num / den;
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        sc.close();

    }
}
