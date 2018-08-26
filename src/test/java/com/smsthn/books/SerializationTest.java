package com.smsthn.books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

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
    public void TrueSerTest(){
        ser = new MsProtoSerialize();
        String s = File.separator;
        String path  = s+"home"+s+"smsthn"+s+"Documents"+s+"Java"+s+"proto"+s+"prsave.dat";
        Book book = ser.deserialize(path);
        logger.printf(Level.ALL,book.getName()+" "+book.getCatagory());
        //logger.printf(Level.ALL,"33333333333333333333333333333333333333333333333333333333333333333");
        assertNotNull(book);
    }


}