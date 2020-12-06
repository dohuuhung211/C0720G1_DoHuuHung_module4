package com.example.blogexample.service;

import com.example.blogexample.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService{
    List<Category> findAll();
}
