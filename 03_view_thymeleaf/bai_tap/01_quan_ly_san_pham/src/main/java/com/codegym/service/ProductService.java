package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product findById(int id);
    void edit(int id, Product product);
    void delete(int id);
    void save(Product product);
}
