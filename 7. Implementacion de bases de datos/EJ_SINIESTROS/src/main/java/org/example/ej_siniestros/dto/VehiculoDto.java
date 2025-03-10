package org.example.ej_siniestros.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ej_siniestros.model.Siniestro;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {

    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    private Integer anio;

    private Integer cantidadRuedas;

}
