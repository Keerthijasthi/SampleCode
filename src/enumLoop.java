// Define the enum
enum Subject {
    MATH("Mathematics"),
    SCIENCE("Science"),
    ENGLISH("English Literature"),
    HISTORY("World History"),
    COMPUTER("Computer Science");

    private final String fullName;
    // Constructor
    Subject(String fullName) {
        this.fullName = fullName;
    }

    // Getter method to access full name
    public String getFullName() {
        return fullName;
    }
}
public class enumLoop {
    public static void main(String[] args) {
//        System.out.print("List of subjects in enum: [" + Subject.MATH.toString());
//        System.out.print(", " + Subject.SCIENCE.toString());
//        System.out.print(", " + Subject.ENGLISH.toString());
//        System.out.print(", " + Subject.HISTORY.toString());
//        System.out.println(", " + Subject.COMPUTER.toString() + "]");

        System.out.println("List of all subjects using enhanced for loop:");
        // Loop through all enum values using Subject.values()
        for (Subject subject : Subject.values()) {
            System.out.println(subject.getFullName());
        }
    }
}
