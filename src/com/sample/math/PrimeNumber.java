package com.sample.math;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Enter a number to check if it's prime: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // discard invalid input
            }
            int num = sc.nextInt();
            boolean isPrime = true;
            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
            System.out.print("Do you want to check another number? (yes/no): ");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("yes"));
        System.out.println("Program ended.");
        sc.close();
    }
}
