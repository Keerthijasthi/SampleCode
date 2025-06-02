package com.sample.student;

import java.util.EnumSet;
enum CourseSubject {
    MATH, SCIENCE, ENGLISH, HISTORY, GEOGRAPHY, COMPUTER_SCIENCE;
}

public class ActiveSubjects {
    public static void main(String[] args) {
        EnumSet<CourseSubject> activeSubjects = EnumSet.of(CourseSubject.MATH,CourseSubject.ENGLISH,CourseSubject.COMPUTER_SCIENCE);
        System.out.println("Active Subjects:");
        for (CourseSubject subject : activeSubjects) {
            System.out.println("- " + subject);
        }

        activeSubjects.add(CourseSubject.SCIENCE);
        System.out.println("\nAfter adding SCIENCE:");
        System.out.println(activeSubjects);

        activeSubjects.remove(CourseSubject.MATH);
        System.out.println("\nAfter removing MATH:");
        System.out.println(activeSubjects);

        if (activeSubjects.contains(CourseSubject.ENGLISH)) {
            System.out.println("\nENGLISH is active.");
        }

        activeSubjects.clear();
        System.out.println("\nAfter clearing all: " + activeSubjects);
    }
}
