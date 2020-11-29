package com.example.blogexample.repository;

import com.example.blogexample.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByNameContainingOrAuthorContaining(String name, String name2);
}
