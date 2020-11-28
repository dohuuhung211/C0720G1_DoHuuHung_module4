package com.example.blogexample.service;

import com.example.blogexample.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void edit(int id, Blog blog);
    void delete(int id);
}
