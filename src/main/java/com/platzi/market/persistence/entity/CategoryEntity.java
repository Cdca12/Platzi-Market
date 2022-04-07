package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String descripcion;

    private Boolean estado;

    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productEntities;



}
