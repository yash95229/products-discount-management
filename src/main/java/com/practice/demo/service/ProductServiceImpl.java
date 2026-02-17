package com.practice.demo.service;

import com.practice.demo.model.Product;
import com.practice.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository ;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findByActiveTrue();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findByIdAndActiveTrue(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
    }

    @Override
    public Product updateProduct(Long id, Product updateProduct) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updateProduct.getName());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setPrice(updateProduct.getPrice());
        return productRepository.save(existingProduct);
    }

    @Override
    public void softDeleteProduct(Long id) {
        Product product = getProductById(id);
        product.setActive(false);
        productRepository.save(product);
    }
}
