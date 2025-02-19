package com.autos.empresaseguros.dto;

import com.autos.empresaseguros.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDto {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaTotal;
}
