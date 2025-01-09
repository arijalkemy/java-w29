package org.example;

import java.util.List;

public class Curriculum extends Documento {
    private String nombre;
    private List<String> habilidades;

    public Curriculum(String autor, String nombre, List<String> habilidades) {
        super(autor);
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Habilidades: " + String.join(", ", habilidades));
    }
}

