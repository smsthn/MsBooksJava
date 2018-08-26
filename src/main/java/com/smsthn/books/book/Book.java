package com.smsthn.books.book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Book implements IBook {
    private static UUID uuid;
    private final String id;
    private String mName;
    private List<String> mTags;
    private String mCatagory;
    private String mReadingStatus;
    private List<String> mNotes;

    public Book() {
        uuid = UUID.randomUUID();
        id = uuid.toString();
        mName = "Book"+id;
        mCatagory = mReadingStatus = "Any";
        mTags = mNotes = new ArrayList<>();
    }

    public Book(String name, String catagory, String readingStatus, List<String> tags) {
        uuid = UUID.randomUUID();
        id = uuid.toString();
        mName = name != null ? name : "Book" + id;
        mCatagory = catagory != null ? catagory : "Any";
        mReadingStatus = readingStatus != null ? readingStatus : "Any";
        mTags = tags != null ? tags : new ArrayList<>();
        mNotes = new ArrayList<>();
    }

    public Book( String name, String catagory, String readingStatus, List<String> tags,
            List<String> notes) {
        this( name, catagory, readingStatus, tags);
        if (notes != null)
            mNotes = notes;
    }

    @Override
    public String GetId() {
        return id;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        if (name != null && name.trim() != "")
            mName = name.trim();
    }

    @Override
    public List<String> getNotes() {
        return mNotes;
    }

    @Override
    public String addNote(String note) {
        if (note != null && note.trim() != "") {
            mNotes.add(note);
            return note;
        }
        return null;

    }

    @Override
    public String removeNote(String note) {
        if (note != null && note.trim() != "") {
            mNotes.remove(note);
            return note;
        }
        return null;
    }

    @Override
    public String removeNote(int index) {
        if (index >= 0 && index > mNotes.size()) {
            String note = mNotes.get(index);
            mNotes.remove(index);
            return note;
        }
        return null;
    }

    @Override
    public List<String> getTags() {
        return mTags;
    }

    @Override
    public String addTag(String tag) {
        if (tag != null && tag.trim() != "") {
            mTags.add(tag);
            return tag;
        }
        return null;
    }

    @Override
    public String removeTag(String tag) {
        if (tag != null && tag.trim() != "") {
            mTags.remove(tag);
            return tag;
        }
        return null;
    }

    @Override
    public String removeTag(int index) {
        if (index >= 0 && index > mTags.size()) {
            String note = mTags.get(index);
            mTags.remove(index);
            return note;
        }
        return null;
    }

    @Override
    public String getCatagory() {
        return mCatagory;
    }

    @Override
    public void setCatagory(String catagory) {
        if (catagory != null && catagory.trim() != "") {
            mCatagory = catagory;
        }
    }

    @Override
    public String getReadingStatus() {
        return mReadingStatus;
    }

    @Override
    public void setReadingStatus(String readingStatus) {
        if (readingStatus != null && readingStatus.trim() != "") {
            mReadingStatus = readingStatus;
        }
    }

    @Override
    public int compareTo(Object object) {
        Book other;
        try {
            other = (Book) object;
        } catch (Exception e) {
            return -1;
        }
        
        return id.compareTo(other.GetId());
            
    }

    @Override
    public boolean compare(Book book){
        return id.equals(book.GetId());
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String){
            return ((String)obj).equalsIgnoreCase(mName);
        }
        if(obj instanceof Book){
            return ((Book)obj).compare(this);
        }
        return false;
    }

	@Override
	public boolean hasCatagory(String catagory) {
		return mCatagory.equalsIgnoreCase(mCatagory);
	}

	@Override
	public boolean hasReadingStatus(String readingStatus) {
		return mReadingStatus.equalsIgnoreCase(mReadingStatus);
	}

	@Override
	public boolean hasTag(String tag) {
		for(String tg : mTags){
            if(tg.equalsIgnoreCase(tag)){
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean hasTags(List<String> tags) {
        boolean has = true;

        if(tags.isEmpty())return has;

        for(String tag : tags){
            has &= hasTag(tag);
        }
        return has;
	}

	@Override
    public String toString() {
        return mName;
    }
}