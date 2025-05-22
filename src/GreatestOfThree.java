import java.util.Scanner;

public class GreatestOfThree {
    // Method to return the greatest of 3 numbers
    public static int findGreatest(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)); // Return the greatest value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking 3 numbers as input from user
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();
        // Call the method and display the result
        int greatest = findGreatest(num1, num2, num3);
        System.out.println("The greatest number is: " + greatest);
    }
}
