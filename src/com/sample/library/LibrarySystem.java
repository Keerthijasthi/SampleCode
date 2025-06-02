package com.sample.library;

import java.util.*;

// com.sample.library.Author class
class Author {
    private final String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "com.sample.library.Author: " + name;
    }
}

    // com.sample.library.com.sample.library.Book class
class Book {
    protected String title;
    protected String isbn;
    protected Author author;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void display() {
        System.out.println("{Title: " + title + ", ISBN: " + isbn + ", " + author + "}");
    }
}

// com.sample.library.FictionBook class extends com.sample.library.com.sample.library.Book
class FictionBook extends com.sample.library.Book {
    public FictionBook(String title, String isbn, Author author) {
        super(title, isbn, author);
    }

    @Override
    public void display() {
        System.out.print("[Fiction] ");
        super.display();
    }
}

// com.sample.library.NonFictionBook class extends com.sample.library.com.sample.library.Book
class NonFictionBook extends com.sample.library.Book {
    public NonFictionBook(String title, String isbn, Author author) {
        super(title, isbn, author);
    }

    @Override
    public void display() {
        System.out.println("[Non-Fiction] ");
        super.display();
    }
}

// com.sample.library.Library class
class Library {
    private final List<com.sample.library.Book> books = new ArrayList<>();

    // Add a book
    public void addBook(com.sample.library.Book book) {
        books.add(book);
    }

    // List all books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("com.sample.library.Library is empty.");
        } else {
            for (com.sample.library.Book book : books) {
                book.display();
            }
        }
    }

    // Search books by author
    public void searchByAuthor(String authorName) {
        boolean found = false;
        for (com.sample.library.Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for author: " + authorName);
        }
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Author orwell = new Author("George Orwell");
        Author hawking = new Author("Stephen Hawking");

        com.sample.library.Book book1 = new FictionBook("1984", "ISBN001", orwell);
        com.sample.library.Book book2 = new NonFictionBook("A Brief History of Time", "ISBN002", hawking);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(new FictionBook("Animal Farm", "ISBN003", orwell));

        System.out.println(" All Books in com.sample.library.Library:");
        library.listBooks();

        System.out.println("\n Search by com.sample.library.Author (George Orwell):");
        library.searchByAuthor("George Orwell");

        System.out.println("\n Search by com.sample.library.Author (J.K. Rowling):");
        library.searchByAuthor("J.K. Rowling");
    }
}
