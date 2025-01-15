package com.mercadolibre.javawave29.concesionaria_de_autos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class VehicleNotFoundError {
    private int status;
    private String message;
}
