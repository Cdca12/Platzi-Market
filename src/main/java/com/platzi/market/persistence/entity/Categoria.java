package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String descripcion;

    private Integer estado;



}
