package com.codegym.service.impl;



import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void edit(int id, Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(findById(id));
    }


//    @Override
//    public List<Blog> search(String search) {
//        return blogRepository.findByNameContainingOrAuthorContaining(search, search);
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> search(String searchName, Pageable pageable) {
        return blogRepository.findBlogByNameContaining(searchName, pageable);
    }

    @Override
    public List<Blog> findAllByNameContaining(String name) {
        return blogRepository.findAllByNameContaining(name);
    }

}
