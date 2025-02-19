package com.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class VentaDto {
    private Long numero;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    private Double total;
    @JsonProperty("medio_pago")
    private String medioPago;
    private Set<PrendaDto> prendas;
}
