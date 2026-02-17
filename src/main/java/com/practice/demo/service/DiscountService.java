package com.practice.demo.service;

import com.practice.demo.model.Discount;

import java.util.List;

public interface DiscountService {
    Discount addDiscountToProduct(Long productId, Discount discount);
    List<Discount> getActiveDiscountsForProduct(Long productId);
    void removeDiscount(Long discountId);
}
