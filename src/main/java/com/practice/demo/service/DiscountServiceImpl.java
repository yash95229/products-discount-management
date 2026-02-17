package com.practice.demo.service;

import com.practice.demo.model.Discount;
import com.practice.demo.model.Product;
import com.practice.demo.repository.DiscountRepository;
import com.practice.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final ProductRepository productRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository, ProductRepository productRepository){
        this.productRepository = productRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public Discount addDiscountToProduct(Long productId, Discount discount) {
        Product product = productRepository.findByIdAndActiveTrue(productId)
                .orElseThrow(()-> new RuntimeException("product not found"));
        discount.setProduct(product);
        return discountRepository.save(discount);
    }

    @Override
    public List<Discount> getActiveDiscountsForProduct(Long productId) {
        return discountRepository.findByProductIdAndActiveTrue(productId);
    }

    @Override
    public void removeDiscount(Long discountId) {
        Discount discount = discountRepository.findByIdAndActiveTrue(discountId)
                .orElseThrow(()-> new RuntimeException("discount not found"));
        discount.setActive(false);
        discountRepository.save(discount);
    }


}
