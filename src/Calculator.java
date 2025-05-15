import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the first number: ");
    double num1 = sc.nextDouble();
    System.out.println("Enter the second number: ");
    double num2 = sc.nextDouble();
    double addition = num1 + num2;
    System.out.println("Addition: " + addition);
    double subtraction = num1 - num2;
    System.out.println("Subtraction: " + subtraction);
    double multiplication = num1 * num2;
    System.out.println("Multiplication: " + multiplication);
    if(num2 !=0){
        double division = num1 / num2;
        System.out.println("The Division is: " + division);
        } else {
        System.out.println("Division: Cannot divide by zero!");
    }
    }
}
