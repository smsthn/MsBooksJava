package com.smsthn.books.serialize;

import com.smsthn.books.book.Book;

public interface IMsSerialize{


    //boolean serialize();

    Book  deserialize(String path);
}