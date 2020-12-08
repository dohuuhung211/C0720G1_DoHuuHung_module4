package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.CartService;
import com.codegym.service.ProductService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @ModelAttribute("cart")
    public List<Product> listProdct() {
        return new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView getAllProduct(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("list_product", "productList", productService.findAllProduct());
        return modelAndView;
    }
    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute(name = "cart") List<Product> cart, RedirectAttributes redirectAttributes){
        Product product = productService.findById(id);
        cart.add(product);

        product.setAmount(product.getAmount()-1);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Added successfully");
        return "redirect:/";
    }
    @GetMapping("/list-cart")
    public ModelAndView getAllCart(@ModelAttribute(name = "cart") List<Product> cartList, RedirectAttributes redirectAttributes){

        ModelAndView modelAndView = new ModelAndView("list_cart", "cartList", cartList);
        if (cartList.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "List cart is empty!");
            return new ModelAndView("redirect:/", "productList", productService.findAllProduct());
        }
        return modelAndView;
    }
    @GetMapping("/remove-product/{id}")
    public String removeProduct(@PathVariable int id, @ModelAttribute(name = "cart") List<Product> cartList, RedirectAttributes redirectAttributes){
        Product product = cartList.get(id);
        cartList.remove(id);
        redirectAttributes.addFlashAttribute("message", "Deleted successfully!");
        product.setAmount(product.getAmount()+1);
        productService.save(product);
        return "redirect:/list-cart";
    }
}
