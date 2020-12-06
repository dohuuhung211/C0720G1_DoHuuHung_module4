package com.codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "cardStudentBook")
public class CardStudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codeborrow;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public CardStudentBook() {
    }
    public CardStudentBook(int id, int codeborrow, boolean status, Book book, Student student){
        this.id = id;
        this.codeborrow = codeborrow;
        this.status = status;
        this.book = book;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeborrow() {
        return codeborrow;
    }

    public void setCodeborrow(int codeborrow) {
        this.codeborrow = codeborrow;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
