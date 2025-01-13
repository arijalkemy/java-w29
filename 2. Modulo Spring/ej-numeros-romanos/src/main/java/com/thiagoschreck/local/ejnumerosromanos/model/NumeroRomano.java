package com.thiagoschreck.local.ejnumerosromanos.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public record NumeroRomano(String valor, @JsonInclude(NON_NULL) String[] descomposicion) {
}
