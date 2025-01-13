package com.example.codigomorse.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CodigoMorseRequest (
    @Pattern(regexp = "^[.-]+( [.-]+)*( {3}[.-]+( [.-]+)*)*$",
            message = "El valor debe contener solo los caracteres '.' y '-', " +
                    "con 1 espacio separando cada letra y 3 espacios separando cada palabra")
    @NotNull(message = "Debe ingresar un código")
    String codigo
) {}
