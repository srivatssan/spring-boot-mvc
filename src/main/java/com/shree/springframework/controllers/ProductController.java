package com.shree.springframework.controllers;

import com.shree.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bheesma on 10/30/2016.
 */
@Controller
public class ProductController {
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    ProductService productService;

    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService.listAllProducts());
        return "products";
    }
}
