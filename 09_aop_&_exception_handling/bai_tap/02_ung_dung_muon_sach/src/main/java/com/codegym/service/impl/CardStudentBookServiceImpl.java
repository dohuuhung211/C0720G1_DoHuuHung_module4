package com.codegym.service.impl;

import com.codegym.entity.CardStudentBook;
import com.codegym.repository.CardStudentBookRepository;
import com.codegym.service.CardStudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardStudentBookServiceImpl implements CardStudentBookService {
    @Autowired
    private CardStudentBookRepository cardStudentBookRepository;
    @Override
    public void save(CardStudentBook cardStudentBook) {
        cardStudentBookRepository.save(cardStudentBook);
    }

    @Override
    public CardStudentBook findById(int id) {
        return cardStudentBookRepository.findById(id).orElse(null);
    }

    @Override
    public CardStudentBook findByCodeborrow(int id) {
        return cardStudentBookRepository.findByCodeborrow(id);
    }
}
