import java.util.*;

import static java.util.Map.entry;

public class StudentMapSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> studentMap = new HashMap<>();
        studentMap.put("S1", "Alex");
        studentMap.put("S4", "Dan");
        studentMap.put("S2", "Bob");
        studentMap.put("S5", "Eve");
        studentMap.put("S3", "Carl");
        //studentMap.remove("S3");

        /*
        studentMap = new HashMap<> (Map.ofEntries(
                entry ("S1", "Alex"),
                entry ("S4", "Bob")
        ));
        */

        // Display all students
        System.out.println("\n--- All Students using default toString of Map ---");
        System.out.println(studentMap);

        System.out.println("\n--- All Students using keySet ---");
        for (String id: studentMap.keySet()) {
            System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
        }

        // Search for student by ID
        System.out.print("\nEnter a Student ID to search: ");
        String searchID = scanner.nextLine();
        if (studentMap.containsKey(searchID)) {
            System.out.println("Student found: " + studentMap.get(searchID));
        } else {
            System.out.println("Student with ID " + searchID + " not found.");
        }
        scanner.close();
    }
}
