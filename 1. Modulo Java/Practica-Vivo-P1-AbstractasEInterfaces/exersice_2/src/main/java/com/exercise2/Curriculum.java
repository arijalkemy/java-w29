package com.exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class Curriculum extends Documento {

    String nombre;
    String profesion;
    List<String> skills;

    public Curriculum(String nombre, String profesion, List<String> skills) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.skills = skills;

    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "   Profesion: " + this.profesion + "   Habilidades: "
                + this.skills.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

}
