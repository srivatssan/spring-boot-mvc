package com.shree.springframework.controllers;

import com.shree.springframework.domain.Product;
import com.shree.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product",new Product());
        return "productform";
    }
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/"+savedProduct.getId();
    }
}
