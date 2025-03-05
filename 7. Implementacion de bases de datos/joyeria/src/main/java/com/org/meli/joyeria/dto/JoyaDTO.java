package com.org.meli.joyeria.dto;

import lombok.Data;

@Data
public class JoyaDTO {
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}