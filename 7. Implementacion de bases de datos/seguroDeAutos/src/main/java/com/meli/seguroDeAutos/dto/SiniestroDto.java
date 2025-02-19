package com.meli.seguroDeAutos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SiniestroDto {
    private Integer id;
    private LocalDate fechaSiniestro;
    private Integer id_vehiculo;
}
