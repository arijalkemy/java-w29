package org.bootcamp.dtoyresponseentityp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
}
