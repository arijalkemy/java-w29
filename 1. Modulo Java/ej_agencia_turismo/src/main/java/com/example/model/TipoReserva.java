package com.example.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoReserva {

    HOTEL("Hotel"),
    BOLETO("Boleto"),
    COMIDA("Comida"),
    TRANSPORTE("Transporte");

    private final String tipo;

}
