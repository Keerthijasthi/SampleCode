//ask the input
//checking if it is number
//return the error
// need to throw the enter the valid number

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1 = getValidNumber(sc, "Enter the first number: ");
        double num2 = getValidNumber(sc, "Enter the second number: ");

        double addition = num1 + num2;
        System.out.println("Addition: " + addition);

        double subtraction = num1 - num2;
        System.out.println("Subtraction: " + subtraction);

        double multiplication = num1 * num2;
        System.out.println("Multiplication: " + multiplication);

        if (num2 != 0) {
            double division = num1 / num2;
            System.out.println("The Division is: " + division);
        } else {
            System.out.println("Division: Cannot divide by zero!");
        }
    }
    private static double getValidNumber(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Enter a valid number.");
                sc.next();
            }
        }
    }
}
