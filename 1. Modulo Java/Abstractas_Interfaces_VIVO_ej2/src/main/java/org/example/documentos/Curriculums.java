package org.example.documentos;

import java.util.ArrayList;
import java.util.List;

public class Curriculums extends Documento{
    private String nombre;
    private int edad;
    private int cedula;
    private List<String> habilidades;

    public Curriculums(String nombre, int edad, int cedula) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidade(String habilidade) {
        this.habilidades.add(habilidade);
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Cedula: " + cedula);
        for (String habilidad : habilidades) {
            System.out.println("Habilidad: " + habilidad);
        }
    }
}
