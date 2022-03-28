package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;



}
