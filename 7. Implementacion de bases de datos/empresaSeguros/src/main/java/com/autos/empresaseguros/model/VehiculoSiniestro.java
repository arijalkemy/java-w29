package com.autos.empresaseguros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaTotal;

}
