package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduc(Long productId) {
        return productRepository.getProduct((productId));
    }

    public Optional<List<Product>> getByCategory(Long categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    // TODO: Implementar luego
    public Optional<List<Product>> getScarseProduct(int quantity) {
        return null;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(Long productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }


}
