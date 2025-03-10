package org.example.ej_siniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloDto {
    private String Patente;
    private String Marca;
    private String Modelo;
}
