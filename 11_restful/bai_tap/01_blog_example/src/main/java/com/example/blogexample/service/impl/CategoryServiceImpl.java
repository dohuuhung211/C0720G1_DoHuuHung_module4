package com.example.blogexample.service.impl;

import com.example.blogexample.model.Category;
import com.example.blogexample.repository.CategoryRepository;
import com.example.blogexample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
