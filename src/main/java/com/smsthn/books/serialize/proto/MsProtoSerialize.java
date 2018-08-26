package com.smsthn.books.serialize.proto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.smsthn.books.book.Book;
import com.smsthn.books.serialize.IMsSerialize;

import MassoudBookSerialization.MassoudBooksSr;

public class MsProtoSerialize implements IMsSerialize {

    @Override
    public List<Book> deserialize(String path) {
        FileInputStream stream;
        MassoudBooksSr.ToSerialize sr;
        Book book;
        try {
            stream = new FileInputStream(path);
            sr = MassoudBooksSr.ToSerialize.parseFrom(stream);
            List<Book> books = new ArrayList<>();
            for (MassoudBooksSr.Book booksr : sr.getAllBooksList()) {
                String name = booksr.getName();
                String catagory = booksr.getCatagory();
                String readingStatus = booksr.getReadingStatus();
                List<String> tags = booksr.getTagList();
                book = new Book(name, catagory, readingStatus, tags);
                book.setPages(booksr.getPages());
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean serialize(String path, List<Book> books, List<String> tags) {
        FileOutputStream stream;
        MassoudBooksSr.ToSerialize.Builder sr;
        
        try {
            stream = new FileOutputStream(path);
            sr = MassoudBooksSr.ToSerialize.newBuilder();
            
            for(Book book : books){
                MassoudBooksSr.Book.Builder booksr = MassoudBooksSr.Book.newBuilder();
                booksr.setName(book.getName());
                booksr.setCatagory(book.getCatagory());
                booksr.setReadingStatus(book.getReadingStatus());
                for(String tag:book.getTags()){
                    booksr.addTag(tag);
                }
                booksr.setPages(book.getPages());
            }

            return true;
        } catch (Exception e) {
            return false;
        } 
    }

}