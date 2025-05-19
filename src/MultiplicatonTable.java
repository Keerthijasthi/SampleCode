import java.util.Scanner;

public class MultiplicatonTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.print("Enter a number to print its multiplication table: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // discard invalid input
        }
        number = sc.nextInt();
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        sc.close();
    }
}
