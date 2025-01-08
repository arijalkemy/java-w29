package org.ejercicio2;

import java.util.ArrayList;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private String edad;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, String edad, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo contenido de " + imprimirTipoDocumento() + ":");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Habilidades: ");
        habilidades.forEach(h -> System.out.println("\t- " + h));
    }
}
