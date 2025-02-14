package com.example.exerciseJoyeriaHibernate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoyaRequestDto {

    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
