package com.mercadolibre.get_price_convertion_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;
}
