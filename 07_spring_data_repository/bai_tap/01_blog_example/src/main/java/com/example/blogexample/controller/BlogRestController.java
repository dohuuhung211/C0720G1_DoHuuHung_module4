package com.example.blogexample.controller;

import com.example.blogexample.model.Blog;
import com.example.blogexample.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/index")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogList = this.blogService.findAll();
        if (blogList.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/blog-index/{id}")
    public ResponseEntity<Blog> getDetailStudent(@PathVariable Integer id) throws Exception {
        Blog blog = this.blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
