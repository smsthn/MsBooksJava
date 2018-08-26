package com.smsthn.books.book;

import java.util.List;

public interface IBook extends Comparable{

    String GetId();

    String getName();
    void setName(String name);

    List<String> getNotes();
    String addNote(String note);
    String removeNote(String note);
    String removeNote(int index);


    List<String> getTags();
    String addTag(String tag);
    String removeTag(String tag);
    String removeTag(int index);

    String getCatagory();
    void setCatagory(String catagory);

    String getReadingStatus();
    void setReadingStatus(String readingStatus);

    int getPages();
    void setPages(int pages);

    boolean compare(Book book);

    boolean hasCatagory(String catagory);
    boolean hasReadingStatus(String readingStatus);
    boolean hasTag(String tag);
    boolean hasTags(List<String> tags);
}