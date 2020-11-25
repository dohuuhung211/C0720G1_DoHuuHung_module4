package com.example.service;

import com.example.model.Email;

import java.util.List;

public interface EmailService {
    List<String> listLang();
    List<Integer> listPage();
    Email save(Email email);
}
