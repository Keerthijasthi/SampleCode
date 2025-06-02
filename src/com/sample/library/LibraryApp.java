//package com.sample.library;
//
//// Interface
//interface FineCalculator {
//    double calculateFine(int overdueDays);
//}
//
//// Abstract class
//abstract class LibraryItem {
//    protected String title;
//    protected String itemId;
//
//    public LibraryItem(String title, String itemId) {
//        this.title = title;
//        this.itemId = itemId;
//    }
//
//    public abstract void displayInfo();
//}
//
//// com.sample.library.Book class
//class Book extends LibraryItem implements FineCalculator {
//
//    public Book(String title, String itemId) {
//        super(title, itemId);
//    }
//
//    @Override
//    public void displayInfo() {
//        System.out.println("com.sample.library.Book - Title: " + title + ", ID: " + itemId);
//    }
//
//    @Override
//    public double calculateFine(int overdueDays) {
//        return overdueDays * 1.0; // $1 per day
//    }
//}
//
//// com.sample.library.DVD class
//class DVD extends LibraryItem implements FineCalculator {
//
//    public DVD(String title, String itemId) {
//        super(title, itemId);
//    }
//
//    @Override
//    public void displayInfo() {
//        System.out.println("com.sample.library.DVD - Title: " + title + ", ID: " + itemId);
//    }
//
//    @Override
//    public double calculateFine(int overdueDays) {
//        return overdueDays * 2.0; // $2 per day
//    }
//}
//
//// com.sample.library.Journal class
//class Journal extends LibraryItem implements FineCalculator {
//
//    public Journal(String title, String itemId) {
//        super(title, itemId);
//    }
//
//    @Override
//    public void displayInfo() {
//        System.out.println("com.sample.library.Journal - Title: " + title + ", ID: " + itemId);
//    }
//
//    @Override
//    public double calculateFine(int overdueDays) {
//        return overdueDays * 0.5; // $0.50 per day
//    }
//}
//public class LibraryApp {
//    public static void main(String[] args) {
//        LibraryItem book = new Book("The Great Gatsby", "B101");
//        LibraryItem dvd = new DVD("Inception", "D202");
//        LibraryItem journal = new Journal("Science Weekly", "J303");
//
//        book.displayInfo();
//        System.out.println("Overdue fine: $" + ((FineCalculator) book).calculateFine(5));
//        System.out.println();
//
//        dvd.displayInfo();
//        System.out.println("Overdue fine: $" + ((FineCalculator) dvd).calculateFine(5));
//        System.out.println();
//
//        journal.displayInfo();
//        System.out.println("Overdue fine: $" + ((FineCalculator) journal).calculateFine(5));
//    }
//}
//
