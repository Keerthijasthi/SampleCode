package com.sample.student;

import java.util.Scanner;

public class WelcomeStudent {
    enum Subject {
        MATH,
        SCIENCE,
        ENGLISH
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a subject name (MATH, SCIENCE, ENGLISH) or a number (1, 2, 3):");
        String input = scanner.nextLine().toUpperCase();
        int id = (int)(Math.random() * 10);
        switch (input) {
            case "MATH":
            case "1":
                System.out.println("Welcome to Math class");
                break;
            case "SCIENCE":
            case "2":
                System.out.println("Welcome to Science class");
                break;
            case "ENGLISH":
            case "3":
                System.out.println("Welcome to English class");
                break;
            default:
                System.out.println("Invalid subject");
                return; // Exit if invalid input
        }

        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("Welcome, com.sample.student.com.sample.student.Student!\n");
        welcomeMessage.append("You have selected: ").append(input).append("\n");
        welcomeMessage.append("Your ID:").append(id).append("\n");
        System.out.println(welcomeMessage.toString());
        scanner.close();
    }
}