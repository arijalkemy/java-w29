package org.example.ejerciciocovid.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ejerciciocovid.Enums.NivelGravedad;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {

    private  Integer codigo;
    private String nombre;
    private NivelGravedad nivelGravedad;
}
