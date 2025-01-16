package com.example.covid.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;

    private List<Sintoma> sintomas;

}
