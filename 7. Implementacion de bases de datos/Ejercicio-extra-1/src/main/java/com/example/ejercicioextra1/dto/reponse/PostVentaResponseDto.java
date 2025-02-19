package com.example.ejercicioextra1.dto.reponse;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PostVentaResponseDto {
    private Long id;
    private LocalDate fecha;
    private Double total;
    private String medioPago;
    private List<PostPrendasResponseDto> prendas;
}
