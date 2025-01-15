package com.mercadolibre.javawave29.concesionaria_de_autos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AddVehicleError {
    private int status;
    private List<String> errors;
}
