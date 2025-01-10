package org.example.documentos;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    List<String> habilidades;

    public Persona(String nombre, String apellido, Integer edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }
}
