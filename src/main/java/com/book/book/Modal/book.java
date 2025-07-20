package com.book.book.Modal;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "books")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Book_id;
    private String Book_name;
    private String Book_Author;
    private String Book_summary;
public book(Integer Book_id,String book_name,String Book_Author,String Book_summary){
    this.Book_id=Book_id;
    this.Book_name=book_name;
    this.Book_Author=Book_Author;
    this.Book_summary=Book_summary;
}

public book(){
}

    public Integer getBook_id() {

        return Book_id;
    }

    public void setBook_id(Integer book_id) {
        Book_id = book_id;
    }

    public String getBook_name() {
        return Book_name;
    }

    public void setBook_name(String book_name) {
        Book_name = book_name;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String book_Author) {
        Book_Author = book_Author;
    }

    public String getBook_summary() {
        return Book_summary;
    }

    public void setBook_summary(String book_summary) {
        Book_summary = book_summary;
    }
}
