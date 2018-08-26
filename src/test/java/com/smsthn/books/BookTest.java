package com.smsthn.books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import com.smsthn.books.book.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest{

    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp(){
        book1 = new Book();
        book2 = new Book("Name","Catagory","ReadingStatus",
            Arrays.asList(new String[]{"Tag","Tag2","Tag3"}),
            Arrays.asList(new String[]{"Note1","Note2","Note3"})
        );
    }

    @Test
    public void NotNullTest(){
        assertNotNull(book1);
        assertNotNull(book2);
        assertNotNull(book1.getCatagory());
        assertNotNull(book1.getName());
        assertNotNull(book1.getReadingStatus());
        assertNotNull(book1.getTags());
        assertNotNull(book1.getNotes());
        assertNotNull(book2.getCatagory());
        assertNotNull(book2.getName());
        assertNotNull(book2.getReadingStatus());
        assertNotNull(book2.getTags());
        assertNotNull(book2.getNotes());
    }
    @Test
    public void randomTests(){
        assertTrue(book1.getName().contains("Book"));
        assertEquals(book2.getName(), "Name");
        assertTrue(book1.getTags().isEmpty());
        assertTrue(book2.getTags().size() == 3);
    }
    @Test
    public void TestComparations(){
        assertNotEquals(0, book1.compareTo(book2));
        assertFalse(book1.compare(book2));
        assertTrue(book2.equals("Name"));
        assertTrue(book1.hasCatagory("Any"));
        assertTrue(book2.hasCatagory("Catagory"));
    }
    @Test
    public void SetStuff(){
        book1.setCatagory("Ctg");
        assertEquals("Ctg", book1.getCatagory());
    }
}