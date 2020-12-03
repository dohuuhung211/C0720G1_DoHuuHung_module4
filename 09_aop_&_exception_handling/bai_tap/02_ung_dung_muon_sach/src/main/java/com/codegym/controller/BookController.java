package com.codegym.controller;

import com.codegym.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("bookList", bookRepository.findAll());
        return "index";
    }
    @GetMapping("/book/{id}/detail")
    public String bookDetail(@PathVariable int id, Model model){
        model.addAttribute("bookDetail", bookRepository.findById(id));
        return "detail";
    }
}
