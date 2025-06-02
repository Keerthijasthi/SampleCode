package com.sample.math;

import java.util.Scanner;
public class Fibonacci {

    // Recursive method to get the nth com.sample.math.Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many com.sample.math.Fibonacci numbers to print: ");
        int count = sc.nextInt();

        if (count < 0) {
            System.out.println("Please enter a non-negative number.");
            return;
        }

        System.out.println("com.sample.math.Fibonacci series up to " + count + " terms:");
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
