package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.entity.CardStudentBook;
import com.codegym.service.BookService;
import com.codegym.service.CardStudentBookService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CardStudentBookService cardStudentBookService;
    @Autowired
    private StudentService studentService;
    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("bookList", bookService.findAll());
        return "index";
    }
    @GetMapping("/book/{id}/borrow")
    public ModelAndView goborrow(@PathVariable int id){
        Book book = bookService.findById(id);
        if (book == null){
            return new ModelAndView("Book empty!");
        }
        int random = new Random().nextInt(99999 - 10000) + 10000;
        ModelAndView modelAndView = new ModelAndView("borrow", "cardStudentBook", new CardStudentBook());
        modelAndView.addObject("book", book);
        modelAndView.addObject("random", random);
        modelAndView.addObject("student", studentService.getAllStudent());

        return modelAndView;
    }
    @PostMapping("/book/borrow")
    public String borrowBook(@ModelAttribute CardStudentBook cardStudentBook){
        cardStudentBookService.save(cardStudentBook);
        cardStudentBook.getBook().setAmount(cardStudentBook.getBook().getAmount()-1);
        bookService.save(cardStudentBook.getBook());
        return "redirect:/";
    }
    @GetMapping("/book/give_book_back")
    public String goGiveBookBack(){
        return "give-book-back";
    }
    @PostMapping("/book/give_book_back")
    public String giveBookBack(@RequestParam int codeborrow, RedirectAttributes redirectAttributes){
        CardStudentBook cardStudentBook = cardStudentBookService.findByCodeborrow(codeborrow);
        if (cardStudentBook != null){
            Book book = cardStudentBook.getBook();
            book.setAmount(book.getAmount()+1);
            cardStudentBook.setStatus(true);
            cardStudentBookService.save(cardStudentBook);
            bookService.save(book);
        } else {
            redirectAttributes.addFlashAttribute("message", "not found code borrow!");
        }
        return "redirect:/";
    }
}
