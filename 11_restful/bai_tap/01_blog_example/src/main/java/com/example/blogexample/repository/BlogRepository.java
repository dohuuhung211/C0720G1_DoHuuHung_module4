package com.example.blogexample.repository;

import com.example.blogexample.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
//    List<Blog> findByNameContainingOrAuthorContaining(String name, String name2);
    Page<Blog> findBlogByNameContaining(String searchString, Pageable pageable);
}
