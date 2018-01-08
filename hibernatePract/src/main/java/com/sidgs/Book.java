package com.sidgs;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name ="Tree")
public class Book {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Id
    @Column(name ="ID")
    private int id;

    @Column(name = "Book")
    private String bookName;

}
