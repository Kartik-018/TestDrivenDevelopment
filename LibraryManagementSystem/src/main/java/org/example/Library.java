// File: Library.java
package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, BookEntry> books = new HashMap<>();

    // Nested class to hold Book and its quantity
    private static class BookEntry {
        Book book;
        int quantity;

        BookEntry(Book book, int quantity) {
            this.book = book;
            this.quantity = quantity;
        }
    }

    // Add a book to the library
    public void addBook(Book book, int quantity) {
        if (books.containsKey(book.getIsbn())) {
            BookEntry entry = books.get(book.getIsbn());
            entry.quantity += quantity; // Increase the count if the book exists
        } else {
            books.put(book.getIsbn(), new BookEntry(book, quantity)); // Add new book
        }
    }

    // View all available books
    public Map<Book, Integer> viewBooks() {
        Map<Book, Integer> availableBooks = new HashMap<>();
        for (BookEntry entry : books.values()) {
            availableBooks.put(entry.book, entry.quantity);
        }
        return availableBooks;
    }

    // Borrow a book from the library
    public String borrowBook(String isbn) {
        if (books.containsKey(isbn)) {
            BookEntry entry = books.get(isbn);
            if (entry.quantity > 0) {
                entry.quantity -= 1;
                if (entry.quantity == 0) {
                    books.remove(isbn);
                }
                return "Book borrowed successfully.";
            }
        }
        return "Book not found.";
    }

    // Return a book to the library
    public void returnBook(String isbn) {
        if (books.containsKey(isbn)) {
            BookEntry entry = books.get(isbn);
            entry.quantity += 1; // Increase quantity of existing book
        } else {
            System.out.println("Book not found in library records, adding it as a new book.");
            books.put(isbn, new BookEntry(new Book(isbn, "Unknown Title", "Unknown Author", 0), 1));
        }
    }
}
