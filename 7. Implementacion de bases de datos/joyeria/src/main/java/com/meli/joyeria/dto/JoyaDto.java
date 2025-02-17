package com.meli.joyeria.dto;

import lombok.Data;

@Data
public class JoyaDto {
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
