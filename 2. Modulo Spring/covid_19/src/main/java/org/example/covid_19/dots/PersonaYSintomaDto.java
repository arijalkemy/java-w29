package org.example.covid_19.dots;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaYSintomaDto {
    private String fullName;
    private int edad;
    private String nombreSintoma;
}
