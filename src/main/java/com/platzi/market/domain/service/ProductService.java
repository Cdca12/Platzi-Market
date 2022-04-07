package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository IProductRepository;

    public List<Product> getAll() {
        return IProductRepository.getAll();
    }

    public Optional<Product> getProduct(Long productId) {
        return IProductRepository.getProduct((productId));
    }

    public Optional<List<Product>> getByCategory(Long categoryId) {
        return IProductRepository.getByCategory(categoryId);
    }

    // TODO: Implementar luego
    public Optional<List<Product>> getScarseProduct(int quantity) {
        return null;
    }

    public Product save(Product product) {
        return IProductRepository.save(product);
    }

    public boolean delete(Long productId) {
        try {
            IProductRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }


}
