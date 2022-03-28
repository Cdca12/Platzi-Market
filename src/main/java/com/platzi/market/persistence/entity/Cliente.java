package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private Double celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;
}
