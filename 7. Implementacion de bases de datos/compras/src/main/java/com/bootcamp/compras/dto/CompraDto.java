package com.bootcamp.compras.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompraDto {
    private int precio;
    @JsonProperty("cantidad_de_productos")
    private int cantidadDeProductos;
    private boolean pagado;
}
