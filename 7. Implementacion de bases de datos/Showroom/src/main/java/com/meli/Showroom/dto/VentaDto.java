package com.meli.Showroom.dto;

import com.meli.Showroom.model.Prenda;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VentaDto {
    private Integer id;
    private Integer numero;
    private LocalDate fecha;
    private Double total;
    private String medioDePago;
    private List<Prenda> prendas;
}
