package com.smsthn.books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import com.smsthn.books.book.Book;
import com.smsthn.books.serialize.proto.MsProtoSerialize;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import org.junit.jupiter.api.Test;


public class SerializationTest{



    private MsProtoSerialize ser;
    private Logger logger = LogManager.getLogger(getClass());

    @Test
    public void DesListTest(){
        ser = new MsProtoSerialize();
        String s = File.separator;
        String path  = s+"home"+s+"smsthn"+s+"Documents"+s+"Java"+s+"proto"+s+"prsave.dat";
        File file = new File(path);
        assertTrue(file.exists());
        List<Book> books = ser.deserialize(path);
        assertNotNull(books);
        //logger.printf(Level.ALL,book.getName()+" "+book.getCatagory());
        //logger.printf(Level.ALL,"33333333333333333333333333333333333333333333333333333333333333333");
       for (Book book : books) {
           logger.printf(Level.ALL, book.getName()+" \n "+book.getCatagory()+" \n "+book.getReadingStatus()+" \n ");
       }
       assertNotEquals(books.size(),0);
       assertTrue(!books.isEmpty());
    }

    @Test
    public void SerializeTest(){
        
    }


}