package org.example.arquitectura_multicapa_1_vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeResponseDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

}
