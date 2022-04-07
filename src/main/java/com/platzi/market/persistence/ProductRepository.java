package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(productEntities);
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        List<ProductEntity> productEntities = productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        List<Product> products = mapper.toProducts(productEntities);
        return Optional.of(products);
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<ProductEntity>> productos = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        Optional<ProductEntity> producto = productCrudRepository.findById(productId);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.toProductEntity(product);
        return mapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(Long productoId) {
        productCrudRepository.deleteById(productoId);
    }



}
