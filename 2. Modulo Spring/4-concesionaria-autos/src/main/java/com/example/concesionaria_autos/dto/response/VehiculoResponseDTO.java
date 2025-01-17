package com.example.concesionaria_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class VehiculoResponseDTO {
    private String descripcion;
    private Long id;
}
