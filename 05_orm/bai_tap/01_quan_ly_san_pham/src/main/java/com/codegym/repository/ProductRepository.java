package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct();

    Product findById(int id);
    void edit(int id, Product product);
    void delete(int id);
    void save(Product product);
}
