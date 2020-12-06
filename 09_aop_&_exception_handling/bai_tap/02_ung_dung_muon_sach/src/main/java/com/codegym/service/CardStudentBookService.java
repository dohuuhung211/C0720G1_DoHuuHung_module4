package com.codegym.service;

import com.codegym.entity.CardStudentBook;
import org.springframework.stereotype.Service;

@Service
public interface CardStudentBookService {
    void save(CardStudentBook cardStudentBook);

    CardStudentBook findById(int id);
    CardStudentBook findByCodeborrow(int id);
}
