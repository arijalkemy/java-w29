package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private Integer edad;
    private ArrayList<String> habilidades;

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Curriculum(String nombre, String apellido, String dni, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidades (String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Dni: " + getDni());
        System.out.println("Edad: " + getEdad());
        for (String h : habilidades){
            System.out.println(h);
        }
    }
}
