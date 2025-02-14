package com.example.exerciseJoyeriaHibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoyaResponseDto {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
