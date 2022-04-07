package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Long> {

    // Query Method
    List<ProductEntity> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    Optional<List<ProductEntity>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    // Query Nativo
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<ProductEntity> getByIdCategoria(Long idCategoria);

}
