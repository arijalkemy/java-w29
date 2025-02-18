package meli.ejercicio.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaDTO {
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer talle;
    private Integer cantidad;
    private Double precioVenta;
}
