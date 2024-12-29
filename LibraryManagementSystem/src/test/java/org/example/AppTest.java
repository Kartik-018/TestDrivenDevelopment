package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Map;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private Library library;

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    @Override
    protected void setUp() { // Corrected method name
        library = new Library();
    }

    public void testAddBook() {
        Book bookA = new Book("1", "TheForgottenSons", "TrinanjanChakraborty", 2020);
        library.addBook(bookA, 3); // Add first time
        library.addBook(bookA, 2); // Add second time
        Book bookB = new Book("2", "RandomBook", "Random", 2024);
        library.addBook(bookB, 1);
        Map<Book, Integer> books = library.viewBooks();
        assertEquals((Integer) 5, books.get(bookA));
        assertEquals((Integer) 1, books.get(bookB));
    }
    public void testBorrowBook(){
        String result=library.borrowBook("1");
        assertEquals("Book borrowed successfully", result);
    }

    public void testApp() {
        testAddBook();
        testBorrowBook();
    }
}
