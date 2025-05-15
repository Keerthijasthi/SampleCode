public class WelcomeStudent {
    enum Subject{
        MATH,
        SCIENCE,
        ENGLISH
    }
    public static void main(String[] args) {
        Subject subject = Subject.MATH;
        int id = (int)(Math.random() * 10);
        switch(subject){
            case MATH:
                System.out.println("Welcome to Math class");
                break;
                case SCIENCE:
                    System.out.println("Welcome to Science class");
                    break;
                    case ENGLISH:
                        System.out.println("Welcome to English class");
                        break;
                        default:
                            System.out.println("Invalid subject");
                            break;
        }
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("Welcome, Student!\n");
        welcomeMessage.append("You have selected: ").append(subject).append("\n");
        welcomeMessage.append("Your ID:").append(id).append("\n");
        System.out.println(welcomeMessage.toString());
    }
}
