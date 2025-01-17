package com.example.__persona.dto_out;

import com.example.__persona.model.Deporte;
import com.example.__persona.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO_In {
    private String nombre;
    private String apellido;
    //private Integer edad;
    private LocalDate fechaNacimiento;
    private Deporte deporte;
}
