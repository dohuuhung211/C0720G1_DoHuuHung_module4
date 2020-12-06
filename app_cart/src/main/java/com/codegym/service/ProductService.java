package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> findAllProduct();

    Product findById(int id);
    void save(Product product);
}
