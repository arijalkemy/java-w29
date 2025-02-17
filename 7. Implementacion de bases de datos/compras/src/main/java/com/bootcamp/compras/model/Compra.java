package com.bootcamp.compras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

import java.time.LocalDate;

@Entity
@IdClass(value = CompraKey.class)
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String clienteId;
    @Id
    private LocalDate fecha;
    private int precio;
    @Column(name = "cantidad_de_productos")
    private int cantidadDeProductos;
    private boolean pagado;
}
