package com.sample.stringutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        // Count character occurrences
        Map<Character, Integer> charCount = countCharacters(input);

        int wordCount = countWords(input);

        // Print word count
        System.out.println("\nTotal number of words: " + wordCount);
        // Print the character counts
        System.out.println("Character counts:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        scanner.close();
    }

    // Method to count characters in a string
    public static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.
                    getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    // Method to count words in a string
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        // Split by one or more whitespace characters
        String[] words = str.trim().split("\\s+");
        return words.length;
    }
}