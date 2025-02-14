package meli.ejercicio.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDto {
    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean poseePiedra;

    private Boolean ventaONo;
}
