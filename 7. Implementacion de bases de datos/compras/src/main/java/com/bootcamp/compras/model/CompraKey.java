package com.bootcamp.compras.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompraKey implements Serializable {
    private String clienteId;
    private LocalDate fecha;
}
