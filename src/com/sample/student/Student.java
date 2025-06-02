//package com.sample.student;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Student {
//
//    private String name;
//    private int marks;
//
//    Student(String name, int marks) {
//        this.name = name;
//        this.marks = marks;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setMarks(int marks) {
//        this.marks = marks;
//    }
//
//    public int getMarks() {
//        return marks;
//    }
//
//    public String toString() {
//        return ("Name: " + name + " Marks: " + marks);
//    }
//
//    public static void main(String[] args) {
//        Student s1=new Student("Alex", 45);
//        Student s2=new Student("Hello", 52);
//        Student s3=new Student("Bob", 23);
//        Student s4=new Student("John", 17);
//        Student s5=new Student("Agya", 22);
//
//        ArrayList<Student> students = new ArrayList<Student>();
//        students.add(s1);
//        students.add(s2);
//        students.add(s3);
//        students.add(s4);
//        students.add(s5);
//
//        System.out.println(students);
//
//        Collections.sort(students, new Comparator<Student>() {
//            public int compare(Student s1, Student s2) {
//                return Integer.compare(s2.name.length(), s1.name.length());
//            }
//        });
//        System.out.println(students);
//
//        Collections.sort(students, new Comparator<Student>() {
//            public int compare(Student s1, Student s2) {
//                return Integer.compare(s2.marks, s1.marks);
//            }
//        });
//        System.out.println(students);
//
//        Collections.sort(students, new Comparator<Student>() {
//            public int compare(Student s1, Student s2) {
//                if (Integer.compare(s2.name.length(), s1.name.length()) == 0)
//                    return Integer.compare(s2.marks, s1.marks);
//                else
//                    return Integer.compare(s2.name.length(), s1.name.length());
//            }
//        });
//        System.out.println(students);
//    }
//}
