package com.example.demo.deportistas;

import lombok.Setter;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;

    public DeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
    public DeportistaDTO() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }
    //
    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }
}
