import java.util.*;

class Student {
    String name;
    int mathScore;
    int scienceScore;
    int englishScore;

    public Student(String name, int math, int science, int english) {
        this.name = name;
        this.mathScore = math;
        this.scienceScore = science;
        this.englishScore = english;
    }

    public int getTotalScore() {
        return mathScore + scienceScore + englishScore;
    }

    @Override
    public String toString() {
        return name + " [Total: " + getTotalScore() + ", Math: " + mathScore + ", Science: " + scienceScore + ", English: " + englishScore + "]";
    }
}

public class StudentRankSystem {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void rankByTotalScore() {
        System.out.println("\nRanking by Total Score (Dense Ranking):");

        Map<Integer, List<Student>> scoreMap = new TreeMap<>(Collections.reverseOrder());

        for (Student s : students) {
            scoreMap.computeIfAbsent(s.getTotalScore(), k -> new ArrayList<>()).add(s);
        }

        int rank = 1;
        for (Map.Entry<Integer, List<Student>> entry : scoreMap.entrySet()) {
            List<Student> sameScoreList = entry.getValue();
            sameScoreList.sort(Comparator.comparing(st -> st.name));
            for (Student s : sameScoreList) {
                System.out.println("Rank " + rank + ": " + s);
            }
            rank++;
        }
    }

    public void rankBySubject(String subject) {
        System.out.println("\nRanking by " + subject + " Score (Dense Ranking):");

        Map<Integer, List<Student>> scoreMap = new TreeMap<>(Collections.reverseOrder());

        for (Student s : students) {
            int score = getSubjectScore(s, subject);
            scoreMap.computeIfAbsent(score, k -> new ArrayList<>()).add(s);
        }

        int rank = 1;
        for (Map.Entry<Integer, List<Student>> entry : scoreMap.entrySet()) {
            List<Student> sameScoreList = entry.getValue();
            sameScoreList.sort(Comparator.comparing(st -> st.name));
            for (Student s : sameScoreList) {
                System.out.println("Rank " + rank + ": " + s);
            }
            rank++;
        }
    }

    public void rankByName() {
        System.out.println("\nRanking by Name:");
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(s -> s.name));
        int rank = 1;
        for (Student s : sorted) {
            System.out.println("Rank " + rank + ": " + s);
            rank++;
        }
    }

    private int getSubjectScore(Student s, String subject) {
        if ("Math".equalsIgnoreCase(subject)) {
            return s.mathScore;
        } else if ("Science".equalsIgnoreCase(subject)) {
            return s.scienceScore;
        } else if ("English".equalsIgnoreCase(subject)) {
            return s.englishScore;
        }
        return 0;
    }

    public static void main(String[] args) {
        StudentRankSystem system = new StudentRankSystem();

        system.addStudent(new Student("Alice", 90, 85, 95));     // Total = 270
        system.addStudent(new Student("Bob", 88, 92, 80));       // Total = 260
        system.addStudent(new Student("Charlie", 90, 85, 95));   // Total = 270
        system.addStudent(new Student("David", 70, 60, 82));     // Total = 212
        system.addStudent(new Student("Eve", 85, 93, 88));       // Total = 266

        system.rankByTotalScore();
        system.rankByName();
        system.rankBySubject("Math");
        system.rankBySubject("Science");
        system.rankBySubject("English");
    }
}
