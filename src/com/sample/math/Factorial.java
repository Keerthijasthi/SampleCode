package com.sample.math;

import java.util.Scanner;

public class Factorial {

    // Recursive method
    public static int factorialRecursive(int n) {
        if (n == 1 || n == 0) {
            return 1; // base case - to stop the recursion
        }
        else {
            return n * factorialRecursive(n - 1); // recursive call-function calling itself until the condition is met
        }
    }

    // Iterative method
    public static int factorialIterative(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result = result * i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        number = Math.abs(number);
        // Iterative result
        int iterativeResult = factorialIterative(number);
        System.out.println("com.sample.math.Factorial (Iterative): " + iterativeResult);

        // Recursive result
        int recursiveResult = factorialRecursive(number);
        System.out.println("com.sample.math.Factorial (Recursive): " + recursiveResult);
    }
}
