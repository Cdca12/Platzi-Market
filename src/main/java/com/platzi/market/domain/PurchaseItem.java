package com.platzi.market.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseItem {
    private Long productId;
    private Integer quantity;
    private BigDecimal total;
    private Boolean active;
}
