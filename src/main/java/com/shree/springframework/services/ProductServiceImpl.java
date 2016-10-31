package com.shree.springframework.services;

import com.shree.springframework.domain.Product;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by Bheesma on 10/30/2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer,Product> products;

    public ProductServiceImpl(){
        loadProducts();
    }
    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }
    public void loadProducts(){
        products = new HashMap<>();

        //Creating first Product
        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setImageUrl("http://products/images/product1.jpg");
        product1.setPrice(new BigDecimal(12.99).setScale(2, RoundingMode.CEILING));
        products.put(1,product1);

        //Creating second Product
        Product product2 = new Product();
        product2.setImageUrl("http://products/images/product2.jpg");
        product2.setPrice(new BigDecimal(10.32).setScale(2, RoundingMode.CEILING));
        product2.setDescription("Product 2");
        product2.setId(2);
        products.put(2,product2);

        //Creating the third Product
        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal(45.65).setScale(2, RoundingMode.CEILING));
        product3.setImageUrl("http://products/images/product3.jpg");
        products.put(3,product3);

        //Creating Product 4

        Product product4 = new Product();
        product4.setImageUrl("http://products/images/product4.jpg");
        product4.setDescription("Product 4") ;
        product4.setPrice(new BigDecimal(34.23).setScale(2, RoundingMode.CEILING));
        product4.setId(4);
        products.put(4,product4);

        //Creating the fifth product
        Product product5 = new Product();
        product5.setId(5);
        product5.setPrice(new BigDecimal(28.94).setScale(2, RoundingMode.CEILING));
        product5.setImageUrl("http://products/images/product5.jpg");
        product5.setDescription("Product 5");
        products.put(5,product5);
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if(product !=null){
            if (product.getId() == null){
                product.setId(getNextKey());
            }
            products.put(product.getId(),product);
            return product;
        }
        else {
            throw new RuntimeException("Product can't be nill");
        }

    }

    private Integer getNextKey(){
        return Collections.max(products.keySet())+1;
    }
}
