package com.example.covid.dto;

import com.example.covid.entity.Sintoma;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SintomaDTO {
    private String nombre;
    private String nivelDeGravedad;

    public SintomaDTO(Sintoma s){
        this.nombre = s.getNombre();
        this.nivelDeGravedad = String.valueOf(s.getNivel());
    }
}
