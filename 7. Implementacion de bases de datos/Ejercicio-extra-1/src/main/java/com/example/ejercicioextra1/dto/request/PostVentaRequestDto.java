package com.example.ejercicioextra1.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PostVentaRequestDto {
    private LocalDate fecha;
    private Double total;
    private String medioPago;
    private List<Long> prendasIds;

}
