package org.meli.models;

import org.meli.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private int edad;
    private String direccion;
    private List<String> habilidades;

    public Curriculum(String nombre, int edad, String direccion, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.habilidades = habilidades;
    }

    @Override
    public String obtenerContenido() {
        return "Curriculum:\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Dirección: " + direccion + "\n" +
                "Habilidades: " + String.join(", ", habilidades);
    }
}
