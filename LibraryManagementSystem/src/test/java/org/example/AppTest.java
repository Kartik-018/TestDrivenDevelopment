// File: AppTest.java
package org.example;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AppTest {
    private Library library;
     @BeforeEach
    void setup(){
         library=new Library();
     }
     @Test
     void testAddSameBookIncreasesQuantity() {
         Book bookA = new Book("1", "TheForgottenSons", "TrinanjanChakraborty", 2020);
         library.addBook(bookA, 3); // Add first time
         library.addBook(bookA, 2); // Add second time
         Book bookB=new Book("2","RandomBook","Random",2024);
         library.addBook(bookB,1);
         Map<Book, Integer> books = library.viewBooks();
         assertEquals(5, books.get(bookA));
         assertEquals(1,books.get(bookB));

     }
}
