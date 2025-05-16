// program: Print the elements of an array in reverse order.
// need to print the elements which are entered by the user in a reverse order for now they are no limitations for elements like the size
// user can give multiple inputs and check the elements based on their choice
import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loopFlag = true;
        while(loopFlag) {
            System.out.print("Enter elements separated by space: ");
            String line = scanner.nextLine();
            String[] arr = line.trim().split("\\s+");
            System.out.println("Array in reverse order:");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("Do you want to continue? (y/n): ");
            String answer = scanner.nextLine();
            if (!(answer.equalsIgnoreCase("y"))) {
                loopFlag = false;
            }
        }
        scanner.close();
    }
}
