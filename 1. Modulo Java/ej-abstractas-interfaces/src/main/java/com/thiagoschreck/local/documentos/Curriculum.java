package com.thiagoschreck.local.documentos;

import java.util.List;
import java.util.stream.Collectors;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad, List<String> habilidades) {
        super(String.format("%s %s, DNI: %s, %s años. Sus habilidades son: %s%n", nombre, apellido, dni, edad,
                habilidades.stream()
                        .map(habilidad -> String.format("%n  * %s", habilidad))
                        .collect(Collectors.joining())));
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }
}
