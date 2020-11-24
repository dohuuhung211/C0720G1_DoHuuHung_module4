package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;
    @GetMapping("/email")
    public String input(Model model){
        model.addAttribute("emailObj", new Email());
        model.addAttribute("listLang", emailService.listLang());
        model.addAttribute("listPage", emailService.listPage());
        return "index";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Email emailObj, Model model){
        model.addAttribute("emailObj", emailObj);
        return "list";
    }
}
