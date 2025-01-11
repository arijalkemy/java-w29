package com.example.__persona.model;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;

    public Persona(String nombre, String apellido, Integer edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Deporte getDeporte() {
        return deporte;
    }
}
