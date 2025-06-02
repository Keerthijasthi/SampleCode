package com.sample.lambastreams;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@ToString
@Builder

class StudentRecord {
    private int id;
    private String name;
}

public class StudentRecordSystem {
    private final List<StudentRecord> studentList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (StudentRecord s : studentList) {
                if (s.getId() == id) {
                    System.out.println("Error: Student ID already exists.\n");
                    return;
                }
            }

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            if (StringUtils.isBlank(name)) {
                System.out.println("Error: Student name cannot be empty.\n");
                return;
            }

            StudentRecord student = StudentRecord.builder()
                    .id(id)
                    .name(name)
                    .build();

            studentList.add(student);
            System.out.println("Student added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.\n");
        }
    }

    public void searchStudent() {
        try {
            System.out.print("Enter Student ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (StudentRecord s : studentList) {
                if (s.getId() == id) {
                    System.out.println("Student Found: " + s + "\n");
                    return;
                }
            }

            System.out.println("Student not found.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.\n");
        }
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.\n");
        } else {
            System.out.println("\n--- Student Records ---");
            ImmutableList<StudentRecord> snapshot = ImmutableList.copyOf(studentList);
            snapshot.forEach(System.out::println);
            System.out.println();
        }
    }

    public void run() {
        int choice = 0;
        do {
            System.out.println("===== Student Record System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
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

    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        system.run();
    }
}
