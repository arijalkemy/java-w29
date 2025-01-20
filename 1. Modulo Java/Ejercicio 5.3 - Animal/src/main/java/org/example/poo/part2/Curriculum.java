package org.example.poo.part2;

import java.util.List;

public class Curriculum implements Imprimible{

    private String nombre;
    private String apellido;
    private String direccion;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String direccion, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de " + nombre + " " + apellido);
        System.out.println("Dirección: " + direccion);
        System.out.println("Habilidades: ");
        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}
