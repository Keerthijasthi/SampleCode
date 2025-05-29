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

    private List<Student> students = new ArrayList<Student>();
    public void addStudent(Student student) {
        students.add(student);
    }

    // Rank by total score descending
    public void rankByTotalScore() {
        rankByComparator(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int totalCompare = s2.getTotalScore() - s1.getTotalScore(); // descending
                if (totalCompare != 0) {
                    return totalCompare;
                }
                return s1.name.compareTo(s2.name); // ascending
            }
        }, "Total Score");
    }

    // Rank by name ascending
    public void rankByName() {
        rankByComparator(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        }, "Name");
    }

    // Rank by specific subject descending, then name ascending
    public void rankBySubject(final String subject) {
        rankByComparator(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int score1 = getSubjectScore(s1, subject);
                int score2 = getSubjectScore(s2, subject);
                int scoreCompare = score2 - score1; // descending
                if (scoreCompare != 0) {
                    return scoreCompare;
                }
                return s1.name.compareTo(s2.name); // ascending
            }
        }, subject + " Score");
    }

    private int getSubjectScore(Student s, String subject) {
        if ("Math".equalsIgnoreCase(subject)) {
            return s.mathScore;
        } else if ("Science".equalsIgnoreCase(subject)) {
            return s.scienceScore;
        } else if ("English".equalsIgnoreCase(subject)) {
            return s.englishScore;
        }
        return 0; // default if subject unknown
    }

    private void rankByComparator(final Comparator<Student> comparator, String rankingTitle) {
        System.out.println("\nRanking by " + rankingTitle + ":");
        // PriorityQueue orders elements based on comparator
        PriorityQueue<Student> pq = new PriorityQueue<Student>(comparator);
        // Add all students to the priority queue
        for (Student s : students) {
            pq.offer(s);
        }
        int rank = 1;
        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.println("Rank " + rank + ": " + s);
            rank++;
        }
    }

    public static void main(String[] args) {
        StudentRankSystem system = new StudentRankSystem();

        system.addStudent(new Student("Alice", 90, 85, 95));
        system.addStudent(new Student("Bob", 88, 92, 80));
        system.addStudent(new Student("Charlie", 92, 84, 94));
        system.addStudent(new Student("David", 70, 60, 82));
        system.addStudent(new Student("Eve", 85, 93, 88));

        system.rankByTotalScore();
        system.rankByName();
        system.rankBySubject("Math");
        system.rankBySubject("Science");
        system.rankBySubject("English");
    }
}
