package com.example.segurosautos.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class MatriculaMarcaModeloPerdidaTotalVehiculoResponseDto {
    private String matricula;
    private String marca;
    private String modelo;
    private Double perdidaTotal;
}
