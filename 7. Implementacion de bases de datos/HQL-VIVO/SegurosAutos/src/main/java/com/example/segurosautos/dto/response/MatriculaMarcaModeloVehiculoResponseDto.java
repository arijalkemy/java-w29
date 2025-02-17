package com.example.segurosautos.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class MatriculaMarcaModeloVehiculoResponseDto {
    private Long matricula;
    private String marca;
    private String modelo;
}
