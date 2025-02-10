package com.example.demo.abstractClass.ej_2;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private int edad;
    private String profesion;
    private List<String> habilidades;

    public Curriculum(String nombre, int edad, String profesion, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.habilidades = habilidades;
    }

    @Override
    public String obtenerContenido() {
        return "Curriculum:\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Profesión: " + profesion + "\n" +
                "Habilidades: " + String.join(", ", habilidades);
    }
}
