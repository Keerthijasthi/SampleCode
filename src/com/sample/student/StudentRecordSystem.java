package com.sample.student;

import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {
    private final int id;
    private final String name;

    public StudentRecord(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class StudentRecordSystem {
    private final ArrayList<StudentRecord> studentList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Method to add a student
    public void addStudent() {
        try {
            System.out.print("Enter com.sample.student.com.sample.student.Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check for duplicate ID
            for (StudentRecord s : studentList) {
                if (s.getId() == id) {
                    System.out.println("Error: com.sample.student.com.sample.student.Student ID already exists.\n");
                    return;
                }
            }

            System.out.print("Enter com.sample.student.com.sample.student.Student Name: ");
            String name = scanner.nextLine();

            studentList.add(new StudentRecord(id, name));
            System.out.println("com.sample.student.com.sample.student.Student added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.\n");
        }
    }

    // Method to search for a student
    public void searchStudent() {
        try {
            System.out.print("Enter com.sample.student.com.sample.student.Student ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (StudentRecord s : studentList) {
                if (s.getId() == id) {
                    System.out.println("com.sample.student.com.sample.student.Student Found: " + s + "\n");
                    return;
                }
            }

            System.out.println("com.sample.student.com.sample.student.Student not found.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.\n");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.\n");
        } else {
            System.out.println("\n--- com.sample.student.com.sample.student.Student Records ---");
            for (StudentRecord s : studentList) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    // Main menu loop
    public void run() {
        int choice;
        do {
            System.out.println("===== com.sample.student.com.sample.student.Student Record System =====");
            System.out.println("1. Add com.sample.student.com.sample.student.Student");
            System.out.println("2. Search com.sample.student.com.sample.student.Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> searchStudent();
                    case 3 -> displayAllStudents();
                    case 4 -> System.out.println("Exiting... Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
                choice = 0;
            }
        } while (choice != 4);
    }

    // Main method
    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        system.run();
    }
}
