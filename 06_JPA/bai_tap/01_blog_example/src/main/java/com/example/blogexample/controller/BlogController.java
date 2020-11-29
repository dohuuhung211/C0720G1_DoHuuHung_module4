package com.example.blogexample.controller;

import com.example.blogexample.model.Blog;
import com.example.blogexample.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/")
    public String showAllBlog(Model model){
        model.addAttribute("blogList", blogService.findAll());
        return "index";
    }
    @GetMapping("/blog/create")
    public String addNewBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Added Successfully!");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        blogService.edit(blog.getId(), blog);
        redirectAttributes.addFlashAttribute("message", "Edited successfully!");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/delete")
    public String goDeletePage(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }
    @PostMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        blogService.delete(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully!");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/view")
    public String viewBlog(@PathVariable int id, Model model){
        model.addAttribute("blogDetail", blogService.findById(id));
        return "view";
    }
    @PostMapping("/blog/search")
    public String search(@RequestParam String search, Model model){
        List<Blog> blogList = blogService.search(search);
        model.addAttribute("blogList", blogList);
        return "index";
    }
}
