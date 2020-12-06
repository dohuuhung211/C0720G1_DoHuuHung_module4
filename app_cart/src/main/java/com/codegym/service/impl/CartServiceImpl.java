package com.codegym.service.impl;

import com.codegym.model.Cart;
import com.codegym.repository.CartRepository;
import com.codegym.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }
}
