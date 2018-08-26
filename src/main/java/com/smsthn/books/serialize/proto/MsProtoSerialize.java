package com.smsthn.books.serialize.proto;

import java.io.FileInputStream;
import java.util.List;

import com.smsthn.books.book.Book;
import com.smsthn.books.serialize.IMsSerialize;

import MassoudBookSerialization.MassoudBooksSr;

public class MsProtoSerialize implements IMsSerialize{



	@Override
	public Book deserialize(String path) {
        FileInputStream stream;
        MassoudBooksSr.ToSerialize sr;
        Book book;
		try{
            stream = new FileInputStream(path);
            sr = MassoudBooksSr.ToSerialize.parseFrom(stream);
            MassoudBookSerialization.MassoudBooksSr.Book booksr= sr.getAllBooks(0);
            String name = booksr.getName();
            String catagory = booksr.getCatagory();
            String readingStatus = booksr.getReadingStatus();
            List<String> tags = booksr.getTagList();
            book = new Book(name,catagory,readingStatus,tags);
            return book;
        } catch(Exception e){
            return null;
        }
	}

}