package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Galaxy Note 20", "Sam Sung", 1200));
        productMap.put(2, new Product(2, "Galaxy Galaxy S20", "Sam Sung", 1200));
        productMap.put(3, new Product(3, "OnePlus 8 Pro", "OnePlus", 100));
        productMap.put(4, new Product(4, "Huawei P40 Pro", "Huawei", 1400));
        productMap.put(5, new Product(5, "Find X2 Pro", "Oppo", 1300));
        productMap.put(6, new Product(6, "OnePlus 8T", "OnePlus", 900));
    }
    @Override
    public List<Product> getAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public int getId() {
        List<Product> products= new ArrayList<>(productMap.values());
        return products.get(products.size()-1).getId();

    }

}
