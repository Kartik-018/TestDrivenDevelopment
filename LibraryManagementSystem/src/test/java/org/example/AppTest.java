// File: AppTest.java
package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private Library library;
     @BeforeEach
    void setup(){
         library=new Library();
     }
     @Test
    void testAddBookUsingArray() {
        library.addBook(new String[]{"1234", "The forgotten sons", "Trinanjan Chakraborty", "2020"}, 1);

    }
}
