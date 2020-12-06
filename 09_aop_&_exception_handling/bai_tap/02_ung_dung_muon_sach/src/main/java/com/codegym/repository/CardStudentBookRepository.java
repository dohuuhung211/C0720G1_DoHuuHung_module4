package com.codegym.repository;

import com.codegym.entity.CardStudentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardStudentBookRepository extends JpaRepository<CardStudentBook, Integer> {
    CardStudentBook findByCodeborrow(int id);
}
