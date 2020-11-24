package com.example.service.impl;

import com.example.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmailServiceImpl implements EmailService {
    private static List<String> languaguesList;
    private static List<Integer> pageList;
    @Override
    public List<String> listLang() {
        languaguesList = new ArrayList<>();
        languaguesList.add("English");
        languaguesList.add("Viet Nam");
        languaguesList.add("ThaiLand");
        languaguesList.add("Germany");
        languaguesList.add("France");
        return languaguesList;
    }

    @Override
    public List<Integer> listPage() {
        pageList.add(10);
        pageList.add(15);
        pageList.add(20);
        pageList.add(25);
        pageList.add(30);
        return pageList;
    }
}
