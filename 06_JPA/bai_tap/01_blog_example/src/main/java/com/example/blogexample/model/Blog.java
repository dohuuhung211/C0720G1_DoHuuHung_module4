package com.example.blogexample.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String author;
    @Column(name = "date_write", columnDefinition = "date")
    private String dateWrite;

    public Blog() {
    }
    public Blog(int id, String name, String content, String author, String dateWrite){
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.dateWrite = dateWrite;
    }
    public String getStringContent(){
        if (this.content.length() < 40){
            return this.content;
        }
        return this.content.substring(0,40).concat("...");
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIdCode(){
        return "B-" + id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(String dateWrite) {
        this.dateWrite = dateWrite;
    }
}
