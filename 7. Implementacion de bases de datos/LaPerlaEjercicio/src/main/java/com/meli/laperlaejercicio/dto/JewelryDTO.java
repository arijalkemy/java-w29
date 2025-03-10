package com.meli.laperlaejercicio.dto;

import lombok.Data;

@Data
public class JewelryDTO {
    private Long nro_id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
