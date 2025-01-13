package org.example.model;

import java.util.List;

public class Client {

    /**
     * Attibutes
     */
    private Long dni;
    private String nombre;
    private String apellido;

    /**
     * Constructor
     */
    public Client(Long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
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

    @Override
    public String toString() {
        return "Client -- " +
                "dni= " + dni + '\n' +
                "nombre= " + nombre + '\n' +
                "apellido= " + apellido + '\n';
    }
}
