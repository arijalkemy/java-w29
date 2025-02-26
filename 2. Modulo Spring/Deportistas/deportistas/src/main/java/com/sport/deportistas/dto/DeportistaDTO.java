package com.sport.deportistas.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
