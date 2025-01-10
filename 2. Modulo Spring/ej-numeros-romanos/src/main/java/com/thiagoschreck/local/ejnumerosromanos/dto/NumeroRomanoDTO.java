package com.thiagoschreck.local.ejnumerosromanos.dto;

public record NumeroRomanoDTO(NumeroRomano numeroRomano, int numeroEntero) {
    public record NumeroRomano(String valor, String[] descomposicion) {
    }
}