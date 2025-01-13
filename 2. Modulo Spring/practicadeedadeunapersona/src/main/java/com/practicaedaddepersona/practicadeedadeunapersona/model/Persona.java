package com.practicaedaddepersona.practicadeedadeunapersona.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Persona {
    private Long id;
    private String fechaNacimiento; // Formato: "yyyy-MM-dd"
}
