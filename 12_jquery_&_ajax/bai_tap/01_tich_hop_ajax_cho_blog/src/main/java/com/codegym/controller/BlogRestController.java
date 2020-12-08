package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-api")
@CrossOrigin
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
    @GetMapping("/search-name/{name}")
    public ResponseEntity<List<Blog>> searchNameBlog(@PathVariable String name, Model model){

        List<Blog> blogList = blogService.findAllByNameContaining(name);
        if (blogList.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
