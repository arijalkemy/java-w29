package com.mercadolibre.javawave29.concesionaria_de_autos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleService {
    private String date;
    private Integer kilometers;
    private String descriptions;
}
