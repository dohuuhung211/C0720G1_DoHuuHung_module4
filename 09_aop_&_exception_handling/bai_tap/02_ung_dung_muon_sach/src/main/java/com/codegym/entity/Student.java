package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "student")
    private List<CardStudentBook> cardStudentBooks;

    public Student() {
    }
    public Student(int id, String name, List<CardStudentBook> cardStudentBooks){
        this.id = id;
        this.name = name;
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

    public List<CardStudentBook> getCardStudentBooks() {
        return cardStudentBooks;
    }

    public void setCardStudentBooks(List<CardStudentBook> cardStudentBooks) {
        this.cardStudentBooks = cardStudentBooks;
    }
}
