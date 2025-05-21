
import java.util.Scanner;
public class WordCount {
// Method to count words in a sentence
public static int countWords(String sentence) {
    // Trim the sentence and split by whitespace
    String[] words = sentence.trim().split("\\s+");
    // Return the length of the array
    return words.length;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        // Count the number of words
        int wordCount = countWords(input);
        // Output the result
        System.out.println("Number of words: " + wordCount);
        scanner.close();
    }
}

