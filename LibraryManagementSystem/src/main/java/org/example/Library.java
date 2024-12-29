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

    // Add a book using a Book object
    public void addBook(Book book, int quantity) {
        if (books.containsKey(book.getIsbn())) {
            BookEntry entry = books.get(book.getIsbn());
            entry.quantity += quantity; // Increase the count if the book exists
        } else {
            books.put(book.getIsbn(), new BookEntry(book, quantity)); // Add new book
        }
    }
    public Map<Book, Integer> viewBooks() {
        Map<Book, Integer> availableBooks = new HashMap<>();
        for (BookEntry entry : books.values()) {
            availableBooks.put(entry.book, entry.quantity);
        }
        return availableBooks;
    }
}
