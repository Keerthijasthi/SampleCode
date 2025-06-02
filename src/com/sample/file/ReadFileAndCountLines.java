package com.sample.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class ReadFileAndCountLines {
    public static void main(String[] args) {

        System.out.println("************File1*************");
        int lineCount = readAndPrintFile1UsingBufferedReader();
        System.out.println("\nTotal number of lines in first file: " + lineCount);

        System.out.println("************File2*************");
        // Read second file
        lineCount = readAndPrintFile2UsingScanner();
        System.out.println("\nTotal number of lines in second file: " + lineCount);
    }

    private static int readAndPrintFile1UsingBufferedReader() {
        String filePath = "C:/Users/keert/OneDrive - UNT System/Desktop/example.txt";
        int lineCount = 0;
        // Read the first file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return lineCount;
    }

    private static int readAndPrintFile2UsingScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the full path of the second file: ");
        String filePath = scanner.nextLine();
        int lineCount = 0;

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            System.out.println("\nContents of the second file:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
                lineCount++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the second file: " + e.getMessage());
        }

        scanner.close();
        return lineCount;
    }
}
