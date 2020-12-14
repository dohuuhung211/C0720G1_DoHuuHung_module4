package com.codeym.repository;

import com.codeym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findBlogByNameContaining(String searchString, Pageable pageable);
    List<Customer> findAllByNameContaining(String name);
}
