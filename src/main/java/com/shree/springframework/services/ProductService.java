package com.shree.springframework.services;

import com.shree.springframework.domain.Product;

import java.util.List;

/**
 * Created by Bheesma on 10/30/2016.
 */
public interface ProductService {
    List<Product> listAllProducts();
}
