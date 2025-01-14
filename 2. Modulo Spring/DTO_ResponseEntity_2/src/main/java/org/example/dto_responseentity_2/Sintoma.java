package org.example.dto_responseentity_2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
