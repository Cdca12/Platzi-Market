package com.platzi.market.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private long productId;
    private String name;
    private long categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private Category category;

}