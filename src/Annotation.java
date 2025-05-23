import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // this is used to read the program during runtime
@Target(ElementType.METHOD)         // this annotation is used on methods
@interface Info {
    String value() default "Utility Method";
}

// Step 2: Create a class that uses the annotation
class Person {
    private String name;
    private LocalDate dob;

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    @Info("Calculate age based on date of birth")
    public int calculateAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Info("Format DOB to readable string")
    public String formatDOB() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dob.format(formatter);
    }

    @Info
    public String getName() {
        return name;
    }

    // method to convert epoch seconds to readable date
    @Info("Convert epoch seconds to readable date")
    public static String convertEpochToReadableDate(long epochSeconds) {
        LocalDate date = Instant.ofEpochSecond(epochSeconds)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(formatter);
    }
}

// Step 3: Use reflection to print annotated methods
public class Annotation {
    public static void main(String[] args) {
        Person person = new Person("Alice", LocalDate.of(1995, 5, 22));

        System.out.println("Name: " + person.getName());
        System.out.println("Formatted DOB: " + person.formatDOB());
        System.out.println("Age: " + person.calculateAge());

        // Example usage of the new method
        long epochExample = 801158400L; // 22 May 1995
        String readableDate = Person.convertEpochToReadableDate(epochExample);
        System.out.println("Epoch to Date: " + readableDate);

        // Show all annotated methods
        System.out.println("\nAnnotated Utility Methods:");
        Method[] methods = Person.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Info.class)) {
                Info info = method.getAnnotation(Info.class);
                System.out.println("- " + method.getName() + ": " + info.value());
            }
        }
    }
}
