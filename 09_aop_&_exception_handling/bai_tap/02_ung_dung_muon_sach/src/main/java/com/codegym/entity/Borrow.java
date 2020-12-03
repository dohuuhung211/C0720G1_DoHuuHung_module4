package com.codegym.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Borrow {
    @Id
    private int id;
    private String name;
    private String author;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "borrow_book",
            joinColumns = { @JoinColumn(name = "borrow_id") },
            inverseJoinColumns = {@JoinColumn(name = "book_id") })
    private List<Borrow> bookList = new ArrayList<>();

    public Borrow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Borrow> getBookList() {
        return bookList;
    }

    public void setBookList(List<Borrow> bookList) {
        this.bookList = bookList;
    }
}
