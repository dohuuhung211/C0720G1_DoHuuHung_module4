package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String input( Model model){
        model.addAttribute("emailObj", new Email());
        model.addAttribute("listLang", emailService.listLang());
        model.addAttribute("listPage", emailService.listPage());
        return "index";
    }
//    @GetMapping("/email")
//    public String save(Model model) {
//        model.addAttribute("emailObj", new Email());
//        return "index";
//    }
    @PostMapping("/update")
    public String update(@ModelAttribute Email emailObj, Model model, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Uploaded!");
        return "redirect:/email";
    }
}
