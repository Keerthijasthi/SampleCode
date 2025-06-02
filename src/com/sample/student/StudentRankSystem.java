package com.sample.student;

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

    private List<com.sample.student.Student> students = new ArrayList<>();

    public void addStudent(com.sample.student.Student student) {
        students.add(student);
    }

    public void rankByTotalScore() {
        System.out.println("\nRanking by Total Score (Dense Ranking):");

        Map<Integer, List<com.sample.student.Student>> scoreMap = new TreeMap<>(Collections.reverseOrder());

        for (com.sample.student.Student s : students) {
            scoreMap.computeIfAbsent(s.getTotalScore(), k -> new ArrayList<>()).add(s);
        }

        int rank = 1;
        for (Map.Entry<Integer, List<com.sample.student.Student>> entry : scoreMap.entrySet()) {
            List<com.sample.student.Student> sameScoreList = entry.getValue();
            sameScoreList.sort(Comparator.comparing(st -> st.name));
            for (com.sample.student.Student s : sameScoreList) {
                System.out.println("Rank " + rank + ": " + s);
            }
            rank++;
        }
    }

    public void rankBySubject(String subject) {
        System.out.println("\nRanking by " + subject + " Score (Dense Ranking):");

        Map<Integer, List<com.sample.student.Student>> scoreMap = new TreeMap<>(Collections.reverseOrder());

        for (com.sample.student.Student s : students) {
            int score = getSubjectScore(s, subject);
            scoreMap.computeIfAbsent(score, k -> new ArrayList<>()).add(s);
        }

        int rank = 1;
        for (Map.Entry<Integer, List<com.sample.student.Student>> entry : scoreMap.entrySet()) {
            List<com.sample.student.Student> sameScoreList = entry.getValue();
            sameScoreList.sort(Comparator.comparing(st -> st.name));
            for (com.sample.student.Student s : sameScoreList) {
                System.out.println("Rank " + rank + ": " + s);
            }
            rank++;
        }
    }

    public void rankByName() {
        System.out.println("\nRanking by Name:");
        List<com.sample.student.Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(s -> s.name));
        int rank = 1;
        for (com.sample.student.Student s : sorted) {
            System.out.println("Rank " + rank + ": " + s);
            rank++;
        }
    }

    private int getSubjectScore(com.sample.student.Student s, String subject) {
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

        system.addStudent(new com.sample.student.Student("Alice", 90, 85, 95));     // Total = 270
        system.addStudent(new com.sample.student.Student("Bob", 88, 92, 80));       // Total = 260
        system.addStudent(new com.sample.student.Student("Charlie", 90, 85, 95));   // Total = 270
        system.addStudent(new com.sample.student.Student("David", 70, 60, 82));     // Total = 212
        system.addStudent(new com.sample.student.Student("Eve", 85, 93, 88));       // Total = 266

        system.rankByTotalScore();
        system.rankByName();
        system.rankBySubject("Math");
        system.rankBySubject("Science");
        system.rankBySubject("English");
    }
}
