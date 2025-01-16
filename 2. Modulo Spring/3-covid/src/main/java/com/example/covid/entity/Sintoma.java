package com.example.covid.entity;

import com.example.covid.enums.NivelGravedadEnum;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sintoma {
    private Long codigo;
    private String nombre;
    private NivelGravedadEnum nivel;
}
