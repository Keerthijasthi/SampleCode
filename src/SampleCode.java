import java.util.HashSet;
import java.util.Set;
public class SampleCode {
    public static void main(String[] args) {
        System.out.println(isValid("HOWDY"));
        System.out.println(isValid("HOODY"));
        System.out.println(isValid("ROWDY"));
    }

    public static boolean isValid(String input) {
        String allowed = "HOWDY";
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (allowed.indexOf(ch) == -1) {
                return false;
            }
            if (seen.contains(ch)) {
                return false;
            }
            seen.add(ch);
        }
        return true;
    }
}

