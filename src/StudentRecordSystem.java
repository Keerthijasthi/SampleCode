import java.util.Scanner;

// class for a StudentData
class StudentData {
    private final int id;
    private final String name;

    public StudentData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Display Student info
    @Override
    public String toString() {
        return ("{ID: " + getId() + ",Name: " + getName() + "}");
    }
}

// Main class
public class StudentRecordSystem {
    private static final StudentData[] students = new StudentData[100];
    private static final Scanner scanner = new Scanner(System.in);

    private static int count = 0;

    public static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            // Duplicate ID check
            for (int i=0; i<StudentRecordSystem.count; i++) {
                if (students[i].getId() == id) {
                    System.out.println("Error: Student with this ID already exists.");
                    return;
                }
            }
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            students[StudentRecordSystem.count++] = new StudentData(id, name);
            System.out.println("Student added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values for ID.\n");
        }
    }

    public static void searchStudent() {
        try {
            System.out.print("Enter Student ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i=0; i<StudentRecordSystem.count; i++) {
                if (students[i].getId() == id) {
                    System.out.println("Student found:" + students[i]);
                    return;
                }
            }
            System.out.println("Student not found.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric ID.\n");
        }
    }

    public static void displayAllStudents() {
        if (StudentRecordSystem.count <= 0) {
            System.out.println("No students to display.\n");
        } else {
            System.out.println("\n--- Student Records ---");
            for (int i=0; i<StudentRecordSystem.count; i++) {
                System.out.println(students[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        searchStudent();
                        break;
                    case 3:
                        displayAllStudents();
                        break;
                    case 4:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
                choice = 0;
            }
        } while (choice != 4);
    }
}