package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll() {
        return productService.getAll();
    }

    public Optional<Product> getProduct(Long productId) {
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(Long categoryId) {
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productService.save(product);
    }

    public boolean delete(Long productId) {
        try {
            productService.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }


}
