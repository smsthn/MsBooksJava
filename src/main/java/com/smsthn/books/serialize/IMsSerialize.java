package com.smsthn.books.serialize;

import java.util.List;

import com.smsthn.books.book.Book;

public interface IMsSerialize{


    boolean serialize(String path, List<Book> books, List<String> tags);

    List<Book>  deserialize(String path);
}