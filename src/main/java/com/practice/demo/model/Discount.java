package com.practice.demo.model;

import com.practice.demo.enums.DiscountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "discounts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private BigDecimal discountValue;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType discountType;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active = true;
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
