package com.sample.controlflow;

import java.util.Scanner;

enum MenuOption {
    ADD,
    VIEW,
    DELETE,
    EXIT
}
public class EnumMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuOption option;
        while (true) {
            // Display the menu
            System.out.println("Menu:");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. DELETE");
            System.out.println("4. EXIT");
            System.out.print("Select an option: ");
            String input = scanner.nextLine().toUpperCase(); // Convert input to uppercase
            try {
                // Parse string input to enum
                option = MenuOption.valueOf(input);
                switch (option) {
                    case ADD:
                        System.out.println("Adding...");
                        break;
                    case VIEW:
                        System.out.println("Viewing...");
                        break;
                    case DELETE:
                        System.out.println("Deleting...");
                        break;
                    case EXIT:
                        System.out.println("Exiting...");
                        scanner.close();
                        return; // Exit the program
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}