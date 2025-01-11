package org.example.Ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible {
    //Atributos
    private String nombre;
    private int edad;
    private List<String> habilidades;

    //Constructor


    public Curriculum(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("Curriculum");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }
}
