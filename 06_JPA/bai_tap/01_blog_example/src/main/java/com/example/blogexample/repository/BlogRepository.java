package com.example.blogexample.repository;

import com.example.blogexample.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
