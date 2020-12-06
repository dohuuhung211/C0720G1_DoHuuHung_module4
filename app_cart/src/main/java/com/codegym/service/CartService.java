package com.codegym.service;

import com.codegym.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAllCart();
}
