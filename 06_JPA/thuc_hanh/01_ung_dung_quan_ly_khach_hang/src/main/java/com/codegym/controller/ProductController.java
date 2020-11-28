package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
//    private ProductService productService = new ProductServiceImpl();
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String getAllProduct(Model model){
        
        model.addAttribute("productList", productService.getAllProduct());
        return "index";
    }
    @GetMapping("/product/create")
    public String createCustomer(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String editProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/update")
    public String editProduct(Product product, RedirectAttributes redirectAttributes){
        productService.edit(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Edited success!");
        return "redirect:/";
    }
//    @GetMapping("/product/{id}/delete")
//    public String deleteProduct(@PathVariable int id, Product product, Model model){
//        model.addAttribute("product", productService.findById(id));
//        return "delete";
//    }
//    @PostMapping("/product/delete")
//    public String delete(Product product, RedirectAttributes redirectAttributes){
//        productService.delete(product.getId());
//        redirectAttributes.addFlashAttribute("message", "Deleted success!");
//        return "redirect:/";
//    }
    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id, Product product, Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("product", productService.findById(id));
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted Success!");
        return "redirect:/";
    }
    @GetMapping("product/{id}/view")
    public String detailProduct(@PathVariable int id, Model model){
        model.addAttribute("productDetail", productService.findById(id));
        return "view";
    }
}
