package com.example.compra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Integer clienteId;
    @Id
    private LocalDate fecha;
}
