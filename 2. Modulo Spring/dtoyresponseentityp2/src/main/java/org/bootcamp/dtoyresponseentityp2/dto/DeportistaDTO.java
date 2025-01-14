package org.bootcamp.dtoyresponseentityp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
