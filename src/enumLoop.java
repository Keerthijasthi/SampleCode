// Define the enum
enum Subject {
    MATH,
    SCIENCE,
    ENGLISH,
    HISTORY,
    COMPUTER
}
public class enumLoop {
    public static void main(String[] args) {
        System.out.print("List of subjects in enum: [" + Subject.MATH.toString());
        System.out.print(", " + Subject.SCIENCE.toString());
        System.out.print(", " + Subject.ENGLISH.toString());
        System.out.print(", " + Subject.HISTORY.toString());
        System.out.println(", " + Subject.COMPUTER.toString() + "]");

        System.out.println("List of all subjects using enhanced for loop:");
        // Loop through all enum values using Subject.values()
        for (Subject subject : Subject.values()) {
            System.out.println(subject);
        }
    }
}
