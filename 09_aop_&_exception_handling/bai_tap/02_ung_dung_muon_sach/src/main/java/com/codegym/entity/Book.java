package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int amount;

    @OneToMany(mappedBy = "book")
    private List<CardStudentBook> cardStudentBooks;


    public Book() {
    }
    public Book(int id, String name, String author, int amount, List<CardStudentBook> cardStudentBooks){
        this.id = id;
        this.name = name;
        this.author = author;
        this.amount = amount;
        this.cardStudentBooks = cardStudentBooks;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<CardStudentBook> getCardStudentBooks() {
        return cardStudentBooks;
    }

    public void setCardStudentBooks(List<CardStudentBook> cardStudentBooks) {
        this.cardStudentBooks = cardStudentBooks;
    }
}
