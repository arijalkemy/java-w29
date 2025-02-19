package com.example.ejercicioextra1.dto.reponse;

import com.example.ejercicioextra1.entity.Prenda;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class GetPrendasForVentaResponseDto {

    private Long id;
    private LocalDate fecha;
    private Double total;
    List<PostPrendasResponseDto> prendas;

}
