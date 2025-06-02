package com.sample.stringutils;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        // Prompt user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Consume invalid input
        }
        rows = sc.nextInt();
        //menu
        System.out.println("Do you want numbered or star pattern? Enter 1 for numbered pattern , 2 for star pattern , 3 for both.");
        int choice;
        choice = sc.nextInt();
        boolean starFlag = (choice == 2);
        System.out.println("Please select option from menu for shape of the pattern\n");
        System.out.println("1. Regular com.sample.stringutils.Pattern \n2. Left Side com.sample.stringutils.Pattern \n3. Right Side com.sample.stringutils.Pattern\n");

        int patternChoice;
        patternChoice = sc.nextInt();
        System.out.println("Selected com.sample.stringutils.Pattern:");
        switch(choice + "" + patternChoice){
            case "11", "21":
                printNormalPattern(rows, starFlag);
                break;
            case "22", "12":
                printLeftSidePattern(rows, starFlag);
                break;
            case "13", "23":
                printRightSidePattern(rows, starFlag);
                break;
            case "31":
                printNormalPattern(rows, true);
                printNormalPattern(rows, false);
                break;
            case "32":
                printLeftSidePattern(rows, true);
                printLeftSidePattern(rows, false);
                break;
            case "33":
                printRightSidePattern(rows, true);
                printRightSidePattern(rows, false);
                break;
            default: System.out.println("Could not print selected pattern due to invalid Input!");
        }
        sc.close();
    }
    private static void printLeftSidePattern(int rows, boolean starFlag) {
        //Left angle triangle
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((starFlag?"*": j )+ " ");
            }
            System.out.println();
        }
    }
    private static void printNormalPattern(int rows, boolean starFlag) {
        //normal pattern
        for (int i = 1; i <= rows; i++) {
            for (int Spacevalue = rows - i; Spacevalue > 0; Spacevalue--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print((starFlag?"*": j) + " ");
            }
            System.out.println();
        }
    }
    private static void printRightSidePattern(int rows, boolean starFlag) {
        //Right angle triangle
        for (int i = 1; i <= rows; i++) {
            for (int Spacevalue = rows - i; Spacevalue > 0; Spacevalue--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print((starFlag?"*": j) + " ");
            }
            System.out.println();

        }
    }
}
