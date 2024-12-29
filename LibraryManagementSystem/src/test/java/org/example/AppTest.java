// File: AppTest.java
package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AppTest {
    private Library library;

    @BeforeEach
    void setup() {
        library = new Library();
    }

    @Test
    void testAddSameBookIncreasesQuantity() {
        Book bookA = new Book("1234", "Playing It My Way", "Sachin Tendulkar", 2014); // Sachin Tendulkar's autobiography
        library.addBook(bookA, 3); // Add first time
        library.addBook(bookA, 2); // Add second time
        Map<Book, Integer> books = library.viewBooks();
        assertEquals(5, books.get(bookA));
    }

    @Test
    void testAddNewBook() {
        Book bookA = new Book("1234", "The Test of My Life", "Yuvraj Singh", 2007); // Yuvraj Singh's biography
        library.addBook(bookA, 3);
        Map<Book, Integer> books = library.viewBooks();
        assertEquals(3, books.get(bookA));
    }

    @Test
    void testBorrowBookSuccess() {
        Book bookA = new Book("1234", "Behind the Shades", "Shane Warne", 2008); // Shane Warne's biography
        library.addBook(bookA, 1);
        String result = library.borrowBook("1234");
        assertEquals("Book borrowed successfully.", result);
        assertFalse(library.viewBooks().containsKey(bookA));
    }

    @Test
    void testBorrowBookNotFound() {
        String result = library.borrowBook("9999"); // Non-existent book
        assertEquals("Book not found.", result);
    }

    @Test
    void testReturnBook() {
        Book bookD = new Book("4321", "The Autobiography of a Yogi", "Paramahansa Yogananda", 1946); // Though not strictly cricket, a spiritual book popular among cricket players
        library.addBook(bookD, 0); // Adding to books collection but no copies initially
        library.returnBook("4321");
        assertEquals(1, library.viewBooks().get(bookD));
    }
}
