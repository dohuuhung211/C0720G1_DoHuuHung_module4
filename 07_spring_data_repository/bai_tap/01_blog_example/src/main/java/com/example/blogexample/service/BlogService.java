package com.example.blogexample.service;

import com.example.blogexample.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void edit(int id, Blog blog);
    void delete(int id);
//    List<Blog> search(String name);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> search(String searchName, Pageable pageable);
}
