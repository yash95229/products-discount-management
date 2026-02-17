package com.practice.demo.service;

import com.practice.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void softDeleteProduct(Long id);
}
