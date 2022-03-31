package com.platzi.market.domain;

import lombok.Data;

@Data
public class Category {

    private long categoryId;
    private String category;
    private boolean active;

}
