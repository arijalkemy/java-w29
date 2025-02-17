package com.example.segurosautos.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PatenteMarcaVehiculoResponseDto {
    String patente;
    String marca;
}
