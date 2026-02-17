package com.practice.demo.controller;

import com.practice.demo.model.Discount;
import com.practice.demo.service.DiscountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService){
        this.discountService = discountService;
    }

    @PostMapping("/{productId}/discounts")
    public Discount addDiscount(@PathVariable Long productId, @RequestBody Discount discount){
       return discountService.addDiscountToProduct(productId, discount);
    }

    @GetMapping("/{productId}/discounts")
    public List<Discount> getActiveDiscounts(@PathVariable Long productId){
        return discountService.getActiveDiscountsForProduct(productId);
    }

    @DeleteMapping("/discounts/{discountId}")
    public String deleteDiscount(@PathVariable Long discountId){
        discountService.removeDiscount(discountId);
        return "Discount removed successfully";
    }
}
